package com.github.fantastic_eureka.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fantastic_eureka.dao.IGenericDao;
import com.github.fantastic_eureka.model.Sneakers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("sneakers")
public class RestSneakersController implements SneakersController {
    private IGenericDao<Sneakers> dao;
    private ImagesController imagesController;
    private ObjectMapper mapper;

    @Autowired
    public RestSneakersController(ImagesController imagesController, ObjectMapper mapper) {
        this.imagesController = imagesController;
        this.mapper = mapper;
    }

    @Autowired
    public void setDao(IGenericDao<Sneakers> dao) {
        this.dao = dao;
        dao.setClazz(Sneakers.class);
    }

    public RestSneakersController(IGenericDao<Sneakers> dao) {
        this.dao = dao;
    }

    @Override
    @GetMapping(value = "/findOne", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public Sneakers getSneakers(@RequestParam long id) {
        return dao.findOne(id);
    }

    @Override
    @GetMapping("/findAll")
    public List<Sneakers> getAllSneakers() {
        return dao.findAll();
    }

    @Override
    @PostMapping(value = "/addNew",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public Sneakers addNewSneakers(@RequestPart("sneakers") String sneakersJson,
                                   @RequestPart("file") MultipartFile file) throws IOException {
        Sneakers sneakers = mapper.readValue(sneakersJson, Sneakers.class);
        sneakers.setImage(imagesController.addNewImage(file));
        dao.create(sneakers);
        return sneakers;
    }

    @Override
    @PutMapping("/update")
    public Sneakers update(@RequestBody Sneakers sneakers) {
        dao.update(sneakers);
        return sneakers;
    }

    @Override
    @DeleteMapping("/delete")
    public void delete(@RequestBody Sneakers sneakers) {
        dao.delete(sneakers);
    }

    @Override
    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam long id) {
        dao.deleteById(id);
    }
}
