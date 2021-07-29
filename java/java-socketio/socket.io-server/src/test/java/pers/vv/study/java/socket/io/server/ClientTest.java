package pers.vv.study.java.socket.io.server;

import io.socket.engineio.client.Socket;
import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.net.URISyntaxException;

public class ClientTest {

    @Test
    void test() throws URISyntaxException {
        Socket socket = new Socket("ws://localhost:8080/");
        socket.on(Socket.EVENT_OPEN, args -> {
            System.out.println("open");
            socket.send("hi");
        });
        socket.open();
        Utils.block();
    }
}
