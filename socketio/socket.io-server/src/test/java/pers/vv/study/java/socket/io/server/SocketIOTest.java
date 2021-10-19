package pers.vv.study.java.socket.io.server;

import io.socket.socketio.server.SocketIoNamespace;
import io.socket.socketio.server.SocketIoServer;
import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.util.Arrays;

public class SocketIOTest extends EngineIOTest {

    private final SocketIoServer server = new SocketIoServer(EngineIOTest.ENGINE_IO_SERVER);

    @Test
    @Override
    void test1() {
        uri = "socket.io";
        prepareEngineIO();
        startEngineIO();
        SocketIoNamespace ns = server.namespace("/");
        ns.on("connect", args -> {
            String s = Arrays.toString(args);
            System.out.println(s);
        });
        Utils.block();
    }
}
