package pers.vv.study.jpa.openjpa.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(JpaProperties.class)
@AutoConfigureAfter({DataSourceAutoConfiguration.class})
@Import(JPAConfig.class)
//@EnableJpaRepositories(basePackages = "pers.vv.study.jpa.common")
//@EntityScan(basePackages = "pers.vv.study.jpa.common")
public class JpaAutoConfiguration {

}