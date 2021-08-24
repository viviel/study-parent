package pers.vv.study.jdk.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PushbackInputStreamTest {

    private final String s = "hello world";

    private ByteArrayInputStream bis;

    @BeforeEach
    void setUp() {
        bis = new ByteArrayInputStream(s.getBytes(UTF_8));
    }

    @Test
    void test1() throws IOException {
        PushbackInputStream pis = new PushbackInputStream(bis, bis.available());
        int available = pis.available();
        byte[] ans = new byte[available];
        pis.read(ans);
        assertEquals(0, pis.available());
        assertEquals(s, new String(ans, UTF_8));
    }

    @Test
    void test2() throws IOException {
        PushbackInputStream pis = new PushbackInputStream(bis, bis.available());
        int available = pis.available();
        byte[] ans = new byte[available];
        pis.read(ans);
        pis.unread(ans);
        assertEquals(available, pis.available());
    }
}
