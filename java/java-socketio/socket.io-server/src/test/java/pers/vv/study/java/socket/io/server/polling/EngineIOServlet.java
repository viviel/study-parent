package pers.vv.study.java.socket.io.server.polling;

import pers.vv.study.java.socket.io.server.EngineIOTest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EngineIOServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EngineIOTest.ENGINE_IO_SERVER.handleRequest(req, resp);
    }
}
