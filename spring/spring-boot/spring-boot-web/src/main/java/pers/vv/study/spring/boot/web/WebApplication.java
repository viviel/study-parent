package pers.vv.study.spring.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
    
//    @Bean
//    public Converter<String, Integer> myConverter() {
//        return Integer::valueOf;
//    }
    
}
