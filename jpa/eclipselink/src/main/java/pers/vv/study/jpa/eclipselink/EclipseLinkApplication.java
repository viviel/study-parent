package pers.vv.study.jpa.eclipselink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"pers.vv.study.jpa.common", "pers.vv.study.jpa.eclipselink"})
public class EclipseLinkApplication {
    
    public static void main(final String[] args) {
        SpringApplication.run(EclipseLinkApplication.class, args);
    }
    
}
