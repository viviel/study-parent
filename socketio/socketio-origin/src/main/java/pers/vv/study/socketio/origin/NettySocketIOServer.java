package pers.vv.study.socketio.origin;

import com.alibaba.fastjson.JSON;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.*;
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

    private void addListener(SocketIOServer ss) {
        ss.addConnectListener(client -> logger.info("[] connected: {}", client.getSessionId()));
        ss.addDisconnectListener(client -> logger.info("[] disconnect: {}", client.getSessionId()));
        ss.addEventListener(
                Socket.EVENT_CONNECT,
                Object.class,
                ((client, data, ackSender) -> logger.info("[] reconnect: {}", client.getSessionId()))
        );
        ss.addPingListener(client -> logger.info(
                "[] ping: {} -- {} -- {}", LocalDateTime.now(), client.getNamespace().getName(), client.getSessionId()
        ));
        ss.addEventListener("message", Object.class, (client, data, ackSender) -> {
            Object d = JSON.toJSON(data);
            logger.info(d.toString());
            ackSender.sendAckData(d);
        });
    }

    private void addNamespace1(SocketIOServer ss) {
        SocketIONamespace ns = ss.addNamespace("/vv");
        ns.addConnectListener(client -> {
            logger.info("[vv] connected: {}", client.getSessionId());
            System.out.println(client.getHandshakeData().getSingleUrlParam("open"));
            client.sendEvent("message", "connected");
            Utils.sleep(1000 * 3);
        });
        ns.addDisconnectListener(client -> logger.info("[vv] disconnect: {}", client.getSessionId()));
        ns.addPingListener(client -> logger.info(
                "[vv] {} -- {} -- {}", LocalDateTime.now(), ns.getName(), client.getSessionId()
        ));
        ns.addEventListener("message", String.class, ((client, data, ackSender) -> {
            ns.getBroadcastOperations().sendEvent(
                    "message", "dd",
                    new BroadcastAckCallback<String>(String.class, 10) {
                        @Override
                        protected void onClientSuccess(SocketIOClient client, String result) {
                            logger.info("success: {}", result);
                        }

                        @Override
                        protected void onClientTimeout(SocketIOClient client) {
                            logger.info("timeout");
                        }
                    }
            );
        }));
    }

    private void addNamespace2(SocketIOServer ss) {
        SocketIONamespace ns = ss.addNamespace("/ww");
        ns.addConnectListener(client -> {
            logger.info("[ww] connected: {}", client.getSessionId());
            System.out.println(client.getHandshakeData().getSingleUrlParam("open"));
        });
        ns.addDisconnectListener(client -> logger.info("[ww] disconnect: {}", client.getSessionId()));
        ns.addPingListener(client -> logger.info(
                "[ww] {} -- {} -- {}", LocalDateTime.now(), ns.getName(), client.getSessionId()
        ));
    }
}
