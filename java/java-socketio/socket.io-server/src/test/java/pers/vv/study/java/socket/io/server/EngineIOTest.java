package pers.vv.study.java.socket.io.server;

import io.socket.engineio.server.EngineIoServer;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EngineIOTest {

    private final EngineIoServer engineIOServer = new EngineIoServer();

    @Test
    void test1() {
        Tomcat tomcat = new Tomcat();
        HttpServlet servlet = getServlet();
        Context context = tomcat.addContext("", null);
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
        return new HttpServlet() {
            @Override
            protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                engineIOServer.handleRequest(req, resp);
            }
        };
    }
}
