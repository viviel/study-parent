/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pers.vv.study.jpa.openjpa.config;

import org.apache.openjpa.persistence.OpenJPAEntityManagerFactorySPI;
import org.apache.openjpa.persistence.OpenJPAEntityManagerSPI;
import org.apache.openjpa.persistence.PersistenceProviderImpl;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import java.util.HashMap;
import java.util.Map;

public class OpenJpaVendorAdapter extends AbstractJpaVendorAdapter {
    
    private final PersistenceProvider persistenceProvider = new PersistenceProviderImpl();
    
    private final OpenJpaDialect jpaDialect = new OpenJpaDialect();
    
    @Override
    @Nonnull
    public PersistenceProvider getPersistenceProvider() {
        return this.persistenceProvider;
    }
    
    @Override
    public String getPersistenceProviderRootPackage() {
        return "org.apache.openjpa";
    }
    
    @Override
    @Nonnull
    public Map<String, Object> getJpaPropertyMap() {
        Map<String, Object> jpaProperties = new HashMap<>();
        
        if (getDatabasePlatform() != null) {
            jpaProperties.put("openjpa.jdbc.DBDictionary", getDatabasePlatform());
        } else {
            String databaseDictonary = determineDatabaseDictionary(getDatabase());
            if (databaseDictonary != null) {
                jpaProperties.put("openjpa.jdbc.DBDictionary", databaseDictonary);
            }
        }
        
        if (isGenerateDdl()) {
            jpaProperties.put("openjpa.jdbc.SynchronizeMappings", "buildSchema(ForeignKeys=true)");
        }
        if (isShowSql()) {
            // Taken from the OpenJPA 0.9.6 docs ("Standard OpenJPA Log Configuration + All SQL Statements")
            jpaProperties.put("openjpa.Log", "DefaultLevel=WARN, Runtime=INFO, Tool=INFO, SQL=TRACE");
        }
        
        return jpaProperties;
    }
    
    /**
     * Determine the OpenJPA database dictionary name for the given database.
     *
     * @param database the specified database
     * @return the OpenJPA database dictionary name, or {@code null} if none found
     */
    protected String determineDatabaseDictionary(Database database) {
        switch (database) {
            case DB2:
                return "db2";
            case DERBY:
                return "derby";
            case HSQL:
                return "hsql(SimulateLocking=true)";
            case INFORMIX:
                return "informix";
            case MYSQL:
                return "mysql";
            case ORACLE:
                return "oracle";
            case POSTGRESQL:
                return "postgres";
            case SQL_SERVER:
                return "sqlserver";
            case SYBASE:
                return "sybase";
            default:
                return null;
        }
    }
    
    @Override
    public OpenJpaDialect getJpaDialect() {
        return this.jpaDialect;
    }
    
    @Override
    @Nonnull
    public Class<? extends EntityManagerFactory> getEntityManagerFactoryInterface() {
        return OpenJPAEntityManagerFactorySPI.class;
    }
    
    @Override
    @Nonnull
    public Class<? extends EntityManager> getEntityManagerInterface() {
        return OpenJPAEntityManagerSPI.class;
    }
    
}