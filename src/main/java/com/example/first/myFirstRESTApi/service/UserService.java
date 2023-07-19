package com.example.first.myFirstRESTApi.service;

import com.example.first.myFirstRESTApi.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Users save(Users user);

    List<Users> getAllUsers();

    Users getUserById(String id);

    String deleteUserById(String id);
}
