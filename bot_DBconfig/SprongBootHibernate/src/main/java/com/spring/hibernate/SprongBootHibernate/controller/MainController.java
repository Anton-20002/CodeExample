package com.spring.hibernate.SprongBootHibernate.controller;

import com.spring.hibernate.SprongBootHibernate.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Anton on 17.12.2018.
 */
@RestController
public class MainController {

    @Autowired
    private XMLService service;

    @RequestMapping("/hibernate")
    public Book getThisBook() {
        return service.getBook1();
    }
}
