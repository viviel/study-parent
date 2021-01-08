package pers.vv.study.socketio.origin;

import com.alibaba.fastjson.JSON;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class NettySocketIOServer {

    Logger logger = LoggerFactory.getLogger(NettySocketIOServer.class);

    public static void main(String[] args) {
        new NettySocketIOServer().start();
    }

    public void start() {
        Configuration config = new Configuration();
        config.setPort(8888);
        config.getSocketConfig().setReuseAddress(true);
        config.setPingInterval(1000 * 5);
        SocketIOServer server = new SocketIOServer(config);
        addListener(server);
        addNamespace(server);
        server.start();
    }

    private void addNamespace(SocketIOServer server) {
        SocketIONamespace namespace = server.addNamespace("/vv");
        namespace.addConnectListener(client -> logger.info("[vv] connected: {}", client.getSessionId()));
        namespace.addDisconnectListener(client -> logger.info("[vv] disconnect: {}", client.getSessionId()));
        namespace.addPingListener(client -> logger.info(
                "[vv] {} -- {} -- {}", LocalDateTime.now(), namespace.getName(), client.getSessionId()
        ));
    }

    private void addListener(SocketIOServer server) {
        server.addConnectListener(client -> logger.info("[] connected: {}", client.getSessionId()));
        server.addDisconnectListener(client -> logger.info("[] disconnect: {}", client.getSessionId()));
        server.addPingListener(client -> logger.info(
                "[] {} -- {} -- {}", LocalDateTime.now(), client.getNamespace().getName(), client.getSessionId()
        ));
        server.addEventListener("message", Object.class, (client, data, ackSender) -> {
            Object d = JSON.toJSON(data);
            logger.info(d.toString());
            ackSender.sendAckData(d);
        });
    }
}
