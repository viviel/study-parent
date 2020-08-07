package pers.vv.study.spring.context;

import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SpringConfig {
    
    @Bean
    public Converter<String, Integer> myConverter() {
        return Integer::valueOf;
    }
    
}
