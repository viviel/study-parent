package pers.vv.study.socketio;

import io.socket.client.IO;
import io.socket.client.Socket;

import java.net.URISyntaxException;

public class SocketIOClient {

    public static void main(String[] args) throws URISyntaxException {
        IO.Options options = new IO.Options();
        Socket socket = IO.socket("http://localhost:8888/vv");
        socket.on(Socket.EVENT_CONNECT, args1 -> {
            System.out.println("connected");
            socket.disconnect();
        });
        socket.connect();
    }

}
