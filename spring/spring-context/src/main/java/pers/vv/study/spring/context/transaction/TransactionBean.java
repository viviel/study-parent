package pers.vv.study.spring.context.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionBean {

    @Transactional
    public void m1() {
        System.out.println("TransactionBean.m1");
    }
}
