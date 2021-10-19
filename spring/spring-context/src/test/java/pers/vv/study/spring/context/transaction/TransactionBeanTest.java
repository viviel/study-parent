package pers.vv.study.spring.context.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

class TransactionBeanTest {

    @EnableTransactionManagement
    @Configuration
    static class Config {
    }

    @Test
    void test1() {
        String path = "pers.vv.study.spring.context.transaction";
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(path);
        TransactionBean bean = ac.getBean(TransactionBean.class);
    }
}
