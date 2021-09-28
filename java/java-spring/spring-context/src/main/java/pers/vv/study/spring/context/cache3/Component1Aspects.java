package pers.vv.study.spring.context.cache3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Component1Aspects {

    @Pointcut("execution(* pers.vv.study.spring.context.circular.references.Component1.m1(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("before: " + name);
    }
}
