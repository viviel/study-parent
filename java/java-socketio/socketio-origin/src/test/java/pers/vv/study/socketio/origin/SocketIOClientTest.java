package pers.vv.study.socketio.origin;

import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;
import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.net.URISyntaxException;
import java.util.Arrays;

class SocketIOClientTest {

    @Test
    void test1() throws URISyntaxException {
        Socket socket = IO.socket("http://localhost:8888/vv");
        socket.on(Socket.EVENT_CONNECT, args1 -> {
            System.out.println("connected");
        });
        socket.on("message", args -> {
            Ack ack = (Ack) args[args.length - 1];
            System.out.println(Arrays.toString(args));
        });
        socket.connect();
        while (!Thread.interrupted()) {
            Utils.sleep(1000);
            if (!socket.connected()) {
                continue;
            }
            socket.emit("message", "message");
        }
    }
}
