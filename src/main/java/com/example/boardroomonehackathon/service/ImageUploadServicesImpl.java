package com.example.boardroomonehackathon.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.example.boardroomonehackathon.service.utill.BackGroundRemover;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
public class ImageUploadServicesImpl implements ImageUploadServices{

    @Autowired
    UserService userService;

    @Autowired
    Cloudinary cloudinary;

    @Autowired
    BackGroundRemover bgRemover;

    @Override
    public Map<?, ?> uploadImage(MultipartFile file) throws IOException {
        byte[] fileBytes = removeBackground(file);
        Map<?, ?> imageProps = ObjectUtils.asMap("transformation", new Transformation()
                .gravity("face")
                .height(200)
                .width(200)
                .crop("fill")
                .chain()
                .opacity(50).chain());
        return cloudinary.uploader().upload(fileBytes, imageProps);
    }

    @Override
    public byte[] removeBackground(MultipartFile file) throws IOException {
        Response response = Request.Post("https://api.remove.bg/v1.0/removebg")
                .addHeader("X-Api-Key", bgRemover.getBgApiKey())
                .body(
                        MultipartEntityBuilder.create()
                                .addBinaryBody("image_file", file.getInputStream())
                                .addTextBody("size", "auto")
                                .build()
                ).execute();
        Content content = response.returnContent();
        return content.asBytes();
    }


}
