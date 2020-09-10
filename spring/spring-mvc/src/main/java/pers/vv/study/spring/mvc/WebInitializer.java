package pers.vv.study.spring.mvc;

import org.springframework.lang.NonNull;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(@NonNull ServletContext servletContext) {
        WebApplicationContext ctx = createApplicationContext(servletContext);
        initServlet(servletContext, ctx);
    }

    private WebApplicationContext createApplicationContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MvcConfig.class);
        ctx.setServletContext(servletContext);
        return ctx;
    }

    private void initServlet(ServletContext sc, WebApplicationContext wac) {
        ServletRegistration.Dynamic servlet = sc.addServlet("dispatcher", new DispatcherServlet(wac));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }

}
