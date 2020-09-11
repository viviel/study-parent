package pers.vv.study.spring.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class SpringConfig {

    @Bean
    public Converter<String, Integer> myConverter() {
        return Integer::valueOf;
    }

}
