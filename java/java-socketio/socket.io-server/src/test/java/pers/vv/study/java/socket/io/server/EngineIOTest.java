package pers.vv.study.java.socket.io.server;

import io.socket.engineio.server.EngineIoServer;
import io.socket.engineio.server.EngineIoSocket;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.websocket.server.WsSci;
import org.junit.jupiter.api.Test;
import pers.vv.study.java.socket.io.server.ws.ApplicationServerConfig;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class EngineIOTest {

    private final EngineIoServer engineIOServer = new EngineIoServer();

    @Test
    void test1() {
        prepareEngineIO();
        startEngineIO();
    }

    private void prepareEngineIO() {
        engineIOServer.on("connection", args -> {
            EngineIoSocket socket = (EngineIoSocket) args[0];
            System.out.println(socket.getId());
        });
    }

    private void startEngineIO() {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("target/tomcat");
        HttpServlet servlet = getServlet();
        Context context = tomcat.addContext("", null);
        context.addServletContainerInitializer(new WsSci(), Collections.singleton(ApplicationServerConfig.class));
        Tomcat.addServlet(context, "dispatch", servlet);
        context.addServletMappingDecoded("/engine.io/*", "dispatch");
        try {
            tomcat.getConnector();
            tomcat.init();
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

    private void prepareServlet(Context context) {

    }

    private HttpServlet getServlet() {
        return new HttpServlet() {
            @Override
            protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                engineIOServer.handleRequest(req, resp);
            }
        };
    }
}
