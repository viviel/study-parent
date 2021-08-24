package pers.vv.study.java.jdk.lang;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharTest {

    /**
     * java使用UTF-16be编码，占用两个字节
     */
    @Test
    void test1() {
        char c = '郭';
    }

    /**
     * UTF-8编码占用三个字节
     */
    @Test
    void test2() {
        String s = "郭";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        assertEquals(3, bytes.length);
    }
}
