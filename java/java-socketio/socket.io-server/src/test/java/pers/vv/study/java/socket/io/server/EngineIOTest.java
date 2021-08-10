package pers.vv.study.java.socket.io.server;

import io.socket.engineio.server.EngineIoServer;
import io.socket.engineio.server.EngineIoSocket;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.websocket.server.WsSci;
import org.junit.jupiter.api.Test;
import pers.vv.study.java.socket.io.server.polling.EngineIOServlet;
import pers.vv.study.java.socket.io.server.ws.ApplicationServerConfig;

import javax.servlet.http.HttpServlet;
import java.util.Arrays;
import java.util.Collections;

public class EngineIOTest {

    public static EngineIoServer ENGINE_IO_SERVER = new EngineIoServer();

    @Test
    void test1() {
        prepareEngineIO();
        startEngineIO();
    }

    private void prepareEngineIO() {
        ENGINE_IO_SERVER.on("connection", args -> {
            EngineIoSocket socket = (EngineIoSocket) args[0];
            System.out.println(socket.getId());
        });
        ENGINE_IO_SERVER.on("message", args -> {
            String s = Arrays.toString(args);
            System.out.println(s);
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

    private HttpServlet getServlet() {
        return new EngineIOServlet();
    }
}
