package com.spring.hibernate.SprongBootHibernate.controller;

import com.spring.hibernate.SprongBootHibernate.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Anton on 18.12.2018.
 */
@Service
@ImportResource("classpath:/app.xml")
public class XMLService {

    @Autowired
    @Qualifier("sf")
    private SessionFactory factory;

    @Autowired
    @Qualifier("emf")
    private EntityManagerFactory factory1;


    Book getBook1() {
        return factory1.createEntityManager().find(Book.class, 1);
    }
    Book getBook() {
        return factory.openSession().get(Book.class,1);
    }

}
