package com.github.fantastic_eureka.sneakers_store_ee_quarkus.utilities;

import com.github.fantastic_eureka.sneakers_store_ee_quarkus.model.Sneakers;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import javax.ws.rs.FormParam;

public class MultipartBody {
    @FormParam("sneakers")
    public String sneakersJson;

    @FormParam("file")
    public FileUpload file;
}
