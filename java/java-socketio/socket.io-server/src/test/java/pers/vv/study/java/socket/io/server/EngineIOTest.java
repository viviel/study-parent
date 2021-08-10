package pers.vv.study.java.socket.io.server;

import io.socket.engineio.server.EngineIoServer;
import io.socket.engineio.server.EngineIoSocket;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.websocket.server.WsSci;
import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;
import pers.vv.study.java.socket.io.server.polling.EngineIOServlet;
import pers.vv.study.java.socket.io.server.ws.ApplicationServerConfig;

import javax.servlet.http.HttpServlet;
import java.util.Arrays;
import java.util.Collections;

public class EngineIOTest {

    public static EngineIoServer ENGINE_IO_SERVER = new EngineIoServer();

    public static String uri = "engine.io";

    @Test
    void test1() {
        prepareEngineIO();
        startEngineIO();
        Utils.block();
    }

    protected void prepareEngineIO() {
        ApplicationServerConfig.uri = uri;
        ENGINE_IO_SERVER.on("connection", args -> {
            EngineIoSocket socket = (EngineIoSocket) args[0];
            System.out.println(socket.getId());
        });
        ENGINE_IO_SERVER.on("message", args -> {
            String s = Arrays.toString(args);
            System.out.println(s);
        });
    }

    protected void startEngineIO() {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("target/tomcat");
        HttpServlet servlet = getServlet();
        Context context = tomcat.addContext("", null);
        context.addServletContainerInitializer(new WsSci(), Collections.singleton(ApplicationServerConfig.class));
        Tomcat.addServlet(context, "dispatch", servlet);
        context.addServletMappingDecoded("/" + uri + "/*", "dispatch");
        try {
            tomcat.getConnector();
            tomcat.init();
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

    private HttpServlet getServlet() {
        return new EngineIOServlet();
    }
}
