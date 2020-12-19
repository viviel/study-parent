package pers.vv.study.jdk.io;

import pers.vv.study.common.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class IOSocketOperator {

    public static void main(String[] args) throws IOException {
        IOSocketOperator o = new IOSocketOperator();
        o.start();
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(8080));
        while (!Thread.currentThread().isInterrupted()) {
            Socket socket = server.accept();
            Utils.cachedThreadPool().submit(() -> {
                try {
                    InputStream in = socket.getInputStream();
                    int len;
                    byte[] buf = new byte[1024];
                    while ((len = in.read(buf)) != -1) {
                        System.out.println(socket.getInetAddress().getHostAddress() + ": " +
                                           new String(buf, 0, len, StandardCharsets.UTF_8));
                    }
                } catch (Exception ignore) {
                }
            });
        }
    }
}
