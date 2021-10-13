package pers.vv.study.java.design.pattern.decorator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

class DecoratorTest {

    private InputStream inputStream;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        inputStream = new FileInputStream("~/test");
    }

    @Test
    void test1() {
        InputStream is = new BufferedInputStream(inputStream);
    }
}
