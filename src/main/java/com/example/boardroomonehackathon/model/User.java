package com.example.boardroomonehackathon.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    private String id;
    private String name;
    private String email;
    private String uploadImage;
}
