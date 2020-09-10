package pers.vv.study.jpa.openjpa.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JPAConfig extends JpaBaseConfiguration {
    
    protected JPAConfig(DataSource dataSource,
                        JpaProperties properties,
                        ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
        super(dataSource, properties, jtaTransactionManager);
    }
    
    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new OpenJpaVendorAdapter();
    }
    
    @Override
    protected Map<String, Object> getVendorProperties() {
        return new HashMap<>();
    }
    
}