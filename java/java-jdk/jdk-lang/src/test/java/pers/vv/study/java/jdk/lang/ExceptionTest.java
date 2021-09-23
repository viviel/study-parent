package pers.vv.study.java.jdk.lang;

import org.junit.jupiter.api.Test;

/**
 * 异常处理、异常表
 */
public class ExceptionTest {

    @Test
    void test1() {
        try {
            System.out.println("try");
        } catch (IllegalArgumentException | IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
