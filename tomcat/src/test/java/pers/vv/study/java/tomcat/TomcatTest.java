package pers.vv.study.java.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServlet;

public class TomcatTest {

    @Test
    void test() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("target/tomcat");
        Context context = tomcat.addContext("", null);
        Tomcat.addServlet(context, "dispatch", getServlet());
        context.addServletMappingDecoded("/uri", "dispatch");
        tomcat.getConnector();
        tomcat.init();
        tomcat.start();
        tomcat.getServer().await();
    }

    private HttpServlet getServlet() {
        return new SimpleServlet();
    }
}
