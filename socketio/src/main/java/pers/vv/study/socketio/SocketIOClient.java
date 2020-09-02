package pers.vv.study.socketio;

import io.socket.client.IO;
import io.socket.client.Socket;

import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class SocketIOClient {

    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        Socket socket = IO.socket("http://localhost:8888/vv");
        socket.connect();
        TimeUnit.SECONDS.sleep(5);
        socket.disconnect();
    }

}
