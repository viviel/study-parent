package pers.vv.study.jpa.eclipselink.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JPAConfig extends JpaBaseConfiguration {
    
    public static final String WEAVING = "static";
    
    public static final String DDL = "create-or-extend-tables";
    
    protected JPAConfig(DataSource dataSource,
                        JpaProperties properties,
                        ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
        super(dataSource, properties, jtaTransactionManager);
    }
    
    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }
    
    @Override
    protected Map<String, Object> getVendorProperties() {
        Map<String, Object> map = new HashMap<>();
        map.put("eclipselink.weaving", WEAVING);
        map.put("eclipselink.ddl-generation", DDL);
        return map;
    }
    
}