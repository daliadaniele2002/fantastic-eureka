package com.github.fantastic_eureka.sneakers_store_ee_quarkus.utilities;

import com.github.fantastic_eureka.sneakers_store_ee_quarkus.model.Image;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.io.IOException;

public interface IImageCreator {
    Image create(FileUpload file) throws IOException;
}
