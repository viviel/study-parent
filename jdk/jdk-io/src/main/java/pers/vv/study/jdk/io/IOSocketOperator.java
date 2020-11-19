package pers.vv.study.jdk.io;

import pers.vv.study.common.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class IOSocketOperator {

    public void start() throws IOException {
        ServerSocket server = new ServerSocket();
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
