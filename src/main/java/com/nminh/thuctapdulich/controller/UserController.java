package com.nminh.thuctapdulich.controller;

import com.nminh.thuctapdulich.entity.User;
import com.nminh.thuctapdulich.model.request.UserLoginRequest;
import com.nminh.thuctapdulich.model.request.UserRequest;
import com.nminh.thuctapdulich.model.response.ApiResponse;
import com.nminh.thuctapdulich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ApiResponse<User> register(@RequestBody UserRequest userRequest) {
       ApiResponse<User> apiResponse = new ApiResponse<>();
       apiResponse.setResult(userService.createUser(userRequest)); // data trả ra là user
       apiResponse.setMessage("success"); // nếu không thêm được thif exception đã xu ly và kh chạy dc đến dòng này
       return apiResponse;
    }

    @PostMapping ("/login")
    public ApiResponse<User> login(@RequestBody UserLoginRequest userDTO) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.loginUser(userDTO));
        apiResponse.setMessage("success");
        return apiResponse;
    }
}
