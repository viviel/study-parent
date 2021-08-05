package pers.vv.study.java.socket.io.server.polling;

import pers.vv.study.java.socket.io.server.EngineIOTest;
import pers.vv.study.java.socket.io.server.HttpServletRequestAdapter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class EngineIOServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpServletRequestAdapter reqAdapter = new HttpServletRequestAdapter(req);
        handle(reqAdapter, resp);
    }

    private void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(req.getMethod() + "  " + LocalDateTime.now());
        System.out.println(req.getQueryString());
        System.out.println();
        EngineIOTest.ENGINE_IO_SERVER.handleRequest(req, resp);
    }
}
