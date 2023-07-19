package com.example.first.myFirstRESTApi.controller;

import com.example.first.myFirstRESTApi.model.Users;
import com.example.first.myFirstRESTApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public Users registerUsers(@RequestBody Users user){

        return userService.save(user);
    }
    @GetMapping
    public List<Users> getUsers(){

        return  userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public Users getSpecificUsers(@PathVariable String id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUsers(@PathVariable String id){

        return userService.deleteUserById(id);
    }

}