$ErrorActionPreference = 'Stop'

Add-Type -TypeDefinition @'
using System;
using System.Collections.Generic;
using System.IO;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

public static class NeoForgeConnectProxy
{
    private static readonly Dictionary<string, string> FixedHosts = new Dictionary<string, string>(StringComparer.OrdinalIgnoreCase)
    {
        { "maven.neoforged.net", "143.244.51.245" },
        { "libraries.minecraft.net", "13.107.253.71" }
    };

    public static void Run()
    {
        var listener = new TcpListener(IPAddress.Parse("127.0.0.1"), 18080);
        listener.Start();

        while (true)
        {
            var client = listener.AcceptTcpClient();
            Task.Run(() => Handle(client));
        }
    }

    private static void Handle(TcpClient client)
    {
        TcpClient server = null;

        try
        {
            using (client)
            {
                var clientStream = client.GetStream();
                var header = ReadHeader(clientStream);
                if (header == null) return;

                var firstLineEnd = header.IndexOf("\r\n", StringComparison.Ordinal);
                var requestLine = firstLineEnd >= 0 ? header.Substring(0, firstLineEnd) : header;
                if (!requestLine.StartsWith("CONNECT ", StringComparison.OrdinalIgnoreCase)) return;

                var target = requestLine.Split(' ')[1];
                var separator = target.LastIndexOf(':');
                if (separator <= 0) return;

                var host = target.Substring(0, separator);
                var port = int.Parse(target.Substring(separator + 1));
                string fixedHost;
                var connectHost = FixedHosts.TryGetValue(host, out fixedHost) ? fixedHost : host;

                server = new TcpClient(connectHost, port);
                using (server)
                {
                    var serverStream = server.GetStream();
                    var response = Encoding.ASCII.GetBytes("HTTP/1.1 200 Connection Established\r\n\r\n");
                    clientStream.Write(response, 0, response.Length);
                    clientStream.Flush();

                    var toServer = clientStream.CopyToAsync(serverStream);
                    var toClient = serverStream.CopyToAsync(clientStream);
                    Task.WaitAny(toServer, toClient);
                }
            }
        }
        catch
        {
            try { if (server != null) server.Close(); } catch { }
            try { if (client != null) client.Close(); } catch { }
        }
    }

    private static string ReadHeader(Stream stream)
    {
        using (var buffer = new MemoryStream())
        {
            int b;
            var window = new Queue<byte>(4);

            while ((b = stream.ReadByte()) >= 0)
            {
                buffer.WriteByte((byte)b);
                window.Enqueue((byte)b);
                if (window.Count > 4) window.Dequeue();

                if (window.Count == 4)
                {
                    var bytes = window.ToArray();
                    if (bytes[0] == 13 && bytes[1] == 10 && bytes[2] == 13 && bytes[3] == 10)
                    {
                        return Encoding.ASCII.GetString(buffer.ToArray());
                    }
                }
            }
        }

        return null;
    }
}
'@

[NeoForgeConnectProxy]::Run()
