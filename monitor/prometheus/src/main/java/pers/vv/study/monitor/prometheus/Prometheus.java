package pers.vv.study.monitor.prometheus;

import io.prometheus.client.Counter;
import io.prometheus.client.exporter.HTTPServer;

import java.io.IOException;

public class Prometheus {

    private static final Counter COUNTER = Counter.build()
            .name("my_library_requests_total")
            .help("Total requests.")
            .register();

    public static void main(String[] args) throws IOException {
        COUNTER.inc();
        COUNTER.inc();
        COUNTER.inc();

        HTTPServer server = new HTTPServer(8080);
    }

}
