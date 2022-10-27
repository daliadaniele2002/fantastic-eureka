package com.github.fantastic_eureka.utilities;

import com.github.fantastic_eureka.model.Image;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class ImageCreator implements IImageCreator{
    @Override
    public Image create(MultipartFile file) throws IOException {
        return new Image(file.getBytes(), file.getOriginalFilename(), file.getContentType(), file.getSize());
    }
}
