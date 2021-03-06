package com.example.boardroomonehackathon;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.boardroomonehackathon.service.utill.CloudinaryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BoardRoomOneHackathonApplication {

    @Autowired
    CloudinaryConfig cloudinaryConfig;



    public static void main(String[] args) {
        SpringApplication.run(BoardRoomOneHackathonApplication.class, args);
    }


    @Bean
    public Cloudinary getCloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudinaryConfig.getCloudName(),
                "api_key", cloudinaryConfig.getApiKey(),
                "api_secret", cloudinaryConfig.getApiSecret()));
    }
}
