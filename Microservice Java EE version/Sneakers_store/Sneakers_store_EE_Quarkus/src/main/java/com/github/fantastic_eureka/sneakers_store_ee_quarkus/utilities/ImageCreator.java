package com.github.fantastic_eureka.sneakers_store_ee_quarkus.utilities;

import com.github.fantastic_eureka.sneakers_store_ee_quarkus.model.Image;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import javax.enterprise.context.Dependent;
import java.io.IOException;
import java.nio.file.Files;

@Dependent
public class ImageCreator implements IImageCreator{
    @Override
    public Image create(FileUpload file) throws IOException {
        byte[] bytes = Files.readAllBytes(file.uploadedFile());
        return new Image(bytes, file.fileName(), file.contentType(), file.size());
    }
}
