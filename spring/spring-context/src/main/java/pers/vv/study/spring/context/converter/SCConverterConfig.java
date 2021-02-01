package pers.vv.study.spring.context.converter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

import java.util.Map;

@Configuration
public class SCConverterConfig implements ApplicationContextAware, InitializingBean {

    private ApplicationContext ac;

    @Bean
    public Converter<String, Integer> myConverter() {
        return Integer::valueOf;
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext ac) throws BeansException {
        this.ac = ac;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Converter> map = ac.getBeansOfType(Converter.class);
        System.out.println(map);
    }
}
