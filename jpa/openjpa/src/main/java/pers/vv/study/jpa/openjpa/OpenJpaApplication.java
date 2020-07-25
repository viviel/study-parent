package pers.vv.study.jpa.openjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class OpenJpaApplication {
    
    public static void main(final String[] args) {
        SpringApplication.run(OpenJpaApplication.class, args);
    }
    
}
