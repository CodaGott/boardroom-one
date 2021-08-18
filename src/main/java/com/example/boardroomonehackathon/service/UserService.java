package com.example.boardroomonehackathon.service;

import com.example.boardroomonehackathon.model.User;
import com.example.boardroomonehackathon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(String email){
        return userRepository.findUserByEmail(email);
    }

}
