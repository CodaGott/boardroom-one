package com.example.boardroomonehackathon.controller;

import com.example.boardroomonehackathon.service.ImageUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
@CrossOrigin(origins = "*", maxAge = 3600)
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
