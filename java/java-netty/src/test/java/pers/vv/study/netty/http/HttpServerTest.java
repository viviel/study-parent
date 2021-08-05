package pers.vv.study.netty.http;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HttpServerTest {

    private HttpServer o;

    @BeforeEach
    void setUp() {
        o = new HttpServer(8888);
    }

    @Test
    void test1() throws Exception {
        o.run();
    }
}
