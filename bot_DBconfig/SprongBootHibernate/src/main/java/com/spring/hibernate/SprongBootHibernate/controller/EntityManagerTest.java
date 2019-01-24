package com.spring.hibernate.SprongBootHibernate.controller;

import com.spring.hibernate.SprongBootHibernate.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Anton on 17.12.2018.
 */
@Service
public class EntityManagerTest {

    @Autowired
    @Qualifier("entity")
    private EntityManagerFactory entityManagerFactory;

    Book getBook() {
        return entityManagerFactory.createEntityManager().find(Book.class, 1);
    }
}
