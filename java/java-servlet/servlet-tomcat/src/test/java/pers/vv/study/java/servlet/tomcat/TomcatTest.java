package pers.vv.study.java.servlet.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TomcatTest {

    @Test
    void test() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        Context context = tomcat.addContext("", null);
        Tomcat.addServlet(context, "dispatch", getServlet());
        context.addServletMappingDecoded("/uri", "dispatch");
        tomcat.getConnector();
        tomcat.init();
        tomcat.start();
        tomcat.getServer().await();
    }

    private HttpServlet getServlet() {
        return new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                resp.getWriter().write("hello, i'm embed tomcat");
            }
        };
    }
}
