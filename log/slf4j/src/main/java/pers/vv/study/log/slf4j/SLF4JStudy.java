package pers.vv.study.log.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JStudy {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(SLF4JStudy.class);
        logger.info("Hello World");
    }

}
