package pers.vv.study.log.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class SLF4JStudy {

    public static void main(String[] args) throws IOException {
        Logger logger = LoggerFactory.getLogger(SLF4JStudy.class);
        logger.info("Hello World");

        Enumeration<URL> r = SLF4JStudy.class.getClassLoader().getResources("org/slf4j/impl/StaticLoggerBinder.class");
        while (r.hasMoreElements()) {
            System.out.println(r.nextElement());
        }
    }

}
