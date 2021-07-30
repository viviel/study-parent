package pers.vv.study.java.socket.io.server;

import io.socket.engineio.client.Socket;
import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.net.URISyntaxException;

public class EngineIOClientTest {

    @Test
    void test() throws URISyntaxException {
        Socket.Options options = getOptions();
        Socket socket = new Socket("ws://localhost:8080/", options);
        socket.on(Socket.EVENT_OPEN, args -> {
            System.out.println("open");
            socket.send("hi");
        });
        socket.open();
        Utils.block();
    }

    private Socket.Options getOptions() {
        Socket.Options op = new Socket.Options();
//        op.transports = new String[]{"websocket"};
        return op;
    }
}
