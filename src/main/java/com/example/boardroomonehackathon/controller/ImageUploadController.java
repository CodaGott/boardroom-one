package com.example.boardroomonehackathon.controller;

import com.example.boardroomonehackathon.service.ImageUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class ImageUploadController {

    @Autowired
    ImageUploadServices imageUploadServices;

    @PostMapping("/add")
    public ResponseEntity<?> imageUpload(@RequestParam("file") MultipartFile file) throws IOException {

        try {
            return new ResponseEntity<>(imageUploadServices.uploadImage(file), HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
