package com.github.fantastic_eureka.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "images")
@Getter
@Setter
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private byte[] data;
    private String fileName;
    private String mimeType;
    private long Size;

    public Image() {
    }

    public Image(byte[] data, String fileName, String mimeType, long size) {
        this.data = data;
        this.fileName = fileName;
        this.mimeType = mimeType;
        Size = size;
    }
}
