package pers.vv.study.spring.context.circular.references;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Component1 {

    @Autowired
    private Component2 component2;
}
