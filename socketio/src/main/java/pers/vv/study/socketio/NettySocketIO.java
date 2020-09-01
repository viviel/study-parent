package pers.vv.study.socketio;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
        SocketIOServer server = new SocketIOServer(config);
        addListener(server);
        server.start();
    }

    private void addListener(SocketIOServer server) {
        server.addEventListener("message", Object.class, (client, data, ackSender) -> {
            Object d = JSON.toJSON(data);
            if (d instanceof JSONObject) {
                JSONObject jsonData = (JSONObject) d;
            }
            System.out.println(data);
            ackSender.sendAckData(data);
        });
    }

}
