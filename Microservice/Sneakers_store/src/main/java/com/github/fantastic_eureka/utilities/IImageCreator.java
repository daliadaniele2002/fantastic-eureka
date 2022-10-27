package com.github.fantastic_eureka.utilities;

import com.github.fantastic_eureka.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImageCreator {
    Image create(MultipartFile file) throws IOException;
}
