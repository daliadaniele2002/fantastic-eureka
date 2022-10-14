package com.github.fantastic_eureka.controller;

import com.github.fantastic_eureka.dao.IGenericDao;
import com.github.fantastic_eureka.model.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sizes")
public class RestSizesController implements SizesController {
    private IGenericDao<Size> dao;

    @Autowired
    public void setDao(IGenericDao<Size> dao) {
        this.dao = dao;
        dao.setClazz(Size.class);
    }

    @Override
    @GetMapping("/findOne")
    public Size getSizes(@RequestParam long id) {
        return dao.findOne(id);
    }

    @Override
    @GetMapping("/findAll")
    public List<Size> getAllSizes() {
        return dao.findAll();
    }

    @Override
    public Size addNewSize(Size size) {
        dao.create(size);
        return size;
    }

    @Override
    public Size update(Size size) {
        dao.update(size);
        return size;
    }

    @Override
    public void delete(Size size) {
        dao.delete(size);
    }

    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }
}
