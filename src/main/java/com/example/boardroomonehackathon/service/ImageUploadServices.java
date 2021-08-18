package com.example.boardroomonehackathon.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ImageUploadServices {


    Map<?, ?> uploadImage(MultipartFile file) throws IOException;

    byte[] removeBackground(MultipartFile file) throws IOException;

}
