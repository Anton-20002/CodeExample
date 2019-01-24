package com.spring.hibernate.SprongBootHibernate.configue;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Anton on 17.12.2018.
 */
@Configuration
public class HibCfgAnother {

    @Autowired
    @Qualifier("entity")
    private EntityManagerFactory entityManagerFactory;

    @Bean(name = "transSession")
    @Qualifier("trans")
    @Primary
    public SessionFactory getFactory() {
            if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
                throw new NullPointerException("factory is not a hibernate factory");
            }
            return entityManagerFactory.unwrap(SessionFactory.class);
    }
}
