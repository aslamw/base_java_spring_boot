package com.api.teste_spring.controllers;


import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.teste_spring.models.User;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {

    private List<User> users = new ArrayList<>();

    @GetMapping("/{id}")
    public User user( @PathVariable("id") Long id) {
        System.out.println("o id é " + id);
        Optional<User> userFind = users.stream().filter(user -> user.getId() == id).findFirst();
        if(userFind.isPresent()){
            return userFind.get();
        }
        return null;
    }

    @PostMapping("/")
    public User user(@RequestBody User user) {
        //TODO: process POST request
        users.add(user);
        
        return user;
    }
    @GetMapping("/list")
    public List<User> list(){
        return users;
    }
    
}
