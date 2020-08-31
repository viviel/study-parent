package pers.vv.study.socketio;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

public class NettySocketIO {

    public static void main(String[] args) {
        new NettySocketIO().start();
    }

    public void start() {
        Configuration config = new Configuration();
        config.setPort(8888);
        config.getSocketConfig().setReuseAddress(true);
        new SocketIOServer(config).start();
    }

}
