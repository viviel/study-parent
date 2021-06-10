package pers.vv.study.socketio.origin;

import com.alibaba.fastjson.JSON;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import io.socket.client.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.vv.study.common.Utils;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class NettySocketIOServer {

    Logger logger = LoggerFactory.getLogger(NettySocketIOServer.class);

    private final ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);

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
        addNamespace1(server);
        addNamespace2(server);
        server.start();
    }

    private void addListener(SocketIOServer server) {
        server.addConnectListener(client -> logger.info("[] connected: {}", client.getSessionId()));
        server.addDisconnectListener(client -> logger.info("[] disconnect: {}", client.getSessionId()));
        server.addEventListener(
                Socket.EVENT_RECONNECT,
                Object.class,
                ((client, data, ackSender) -> logger.info("[] reconnect: {}", client.getSessionId()))
        );
        server.addPingListener(client -> logger.info(
                "[] ping: {} -- {} -- {}", LocalDateTime.now(), client.getNamespace().getName(), client.getSessionId()
        ));
        server.addEventListener("message", Object.class, (client, data, ackSender) -> {
            Object d = JSON.toJSON(data);
            logger.info(d.toString());
            ackSender.sendAckData(d);
        });
    }

    private void addNamespace1(SocketIOServer server) {
        SocketIONamespace namespace = server.addNamespace("/vv");
        namespace.addConnectListener(client -> {
            logger.info("[vv] connected: {}", client.getSessionId());
            System.out.println(client.getHandshakeData().getSingleUrlParam("open"));
            client.sendEvent("message", "connected");
            Utils.sleep(1000 * 3);
        });
        namespace.addDisconnectListener(client -> logger.info("[vv] disconnect: {}", client.getSessionId()));
        namespace.addPingListener(client -> logger.info(
                "[vv] {} -- {} -- {}", LocalDateTime.now(), namespace.getName(), client.getSessionId()
        ));
    }

    private void addNamespace2(SocketIOServer server) {
        SocketIONamespace namespace = server.addNamespace("/ww");
        namespace.addConnectListener(client -> {
            logger.info("[ww] connected: {}", client.getSessionId());
            System.out.println(client.getHandshakeData().getSingleUrlParam("open"));
        });
        namespace.addDisconnectListener(client -> logger.info("[ww] disconnect: {}", client.getSessionId()));
        namespace.addPingListener(client -> logger.info(
                "[ww] {} -- {} -- {}", LocalDateTime.now(), namespace.getName(), client.getSessionId()
        ));
    }
}
