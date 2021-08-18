package com.example.boardroomonehackathon.service.utill;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class BackGroundRemover {

    @Value("${X-Api-Key}")
    private String bgApiKey;
}
