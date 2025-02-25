package com.nminh.thuctapdulich.controller;

import com.nminh.thuctapdulich.model.request.UserRequest;
import com.nminh.thuctapdulich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public String register(@RequestBody UserRequest userRequest) {
        if(userService.createUser(userRequest)) {
            return " Register success";
        }
        return " Register failed";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserRequest userRequest) {
        if(userService.loginUser(userRequest)) {
            return " Login success";
        }
        return "Login failed";
    }
}
