package com.spring.hibernate.SprongBootHibernate.controller;

import com.spring.hibernate.SprongBootHibernate.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Anton on 17.12.2018.
 */
@Service
public class HibernateTest {

//    @Autowired
//    @Qualifier("session")
//    private Session session;
//
//    Book getBook() {
//    return session.get(Book.class, 1);
//    }
    @Autowired
    @Qualifier("trans")
    private SessionFactory factory;

    Book getBook() {
       return factory.openSession().get(Book.class, 1);
    }

}
