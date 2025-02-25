package com.nminh.thuctapdulich.controller;

import com.nminh.thuctapdulich.model.request.UserLoginRequest;
import com.nminh.thuctapdulich.model.request.UserRequest;
import com.nminh.thuctapdulich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping ("/login")
    public String login(@RequestBody UserLoginRequest userDTO) {
        if(userService.loginUser(userDTO)) {
            return " Login success";
        }
        return "Login failed";
    }
}
