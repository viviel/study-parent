package pers.vv.study.springboot.web;

import com.google.common.cache.RemovalListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

@SpringBootApplication
public class WebApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
    
    @Bean
    public Converter<String, Integer> converter() {
        return source -> Integer.valueOf(source);
    }
    
}
