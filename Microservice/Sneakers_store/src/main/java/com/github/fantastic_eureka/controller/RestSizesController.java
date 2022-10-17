package com.github.fantastic_eureka.controller;

import com.github.fantastic_eureka.dao.IGenericDao;
import com.github.fantastic_eureka.model.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/addNew")
    public Size addNewSize(@RequestBody Size size) {
        dao.create(size);
        return size;
    }

    @Override
    @PutMapping("/update")
    public Size update(@RequestBody Size size) {
        dao.update(size);
        return size;
    }

    @Override
    @DeleteMapping("/delete")
    public void delete(@RequestBody Size size) {
        dao.delete(size);
    }

    @Override
    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam long id) {
        dao.deleteById(id);
    }
}
