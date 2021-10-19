package pers.vv.study.spring.boot.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class WebConfig {

    //    @Bean
    public Converter<String, Integer> myConverter() {
        return Integer::valueOf;
    }
}
