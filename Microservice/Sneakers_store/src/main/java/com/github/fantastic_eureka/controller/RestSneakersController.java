package com.github.fantastic_eureka.controller;

import com.github.fantastic_eureka.dao.IGenericDao;
import com.github.fantastic_eureka.model.Sneakers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestSneakersController implements SneakersController {
    private IGenericDao<Sneakers> dao;

    @Autowired
    public void setDao(IGenericDao<Sneakers> dao) {
        System.out.println("AYE");
        this.dao = dao;
        dao.setClazz(Sneakers.class);
    }

    public RestSneakersController(IGenericDao<Sneakers> dao) {
        this.dao = dao;
    }

    @Override
    @GetMapping("sneakers/findOne")
    public Sneakers getSneakers(long id) {
        return dao.findOne(1);
    }

    @Override
    public List<Sneakers> getAllSneakers() {
        return dao.findAll();
    }

    @Override
    public Sneakers addNewSneakers(Sneakers sneakers) {
        dao.create(sneakers);
        return sneakers;
    }

    @Override
    public Sneakers update(Sneakers sneakers) {
        dao.update(sneakers);
        return sneakers;
    }

    @Override
    public void delete(Sneakers sneakers) {
        dao.delete(sneakers);
    }

    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }
}
