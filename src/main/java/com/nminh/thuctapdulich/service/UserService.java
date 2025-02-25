package com.nminh.thuctapdulich.service;

import com.nminh.thuctapdulich.entity.User;
import com.nminh.thuctapdulich.model.request.UserLoginRequest;
import com.nminh.thuctapdulich.model.request.UserRequest;


public interface  UserService {
    public User createUser(UserRequest userRequest) ;
    public User loginUser(UserLoginRequest userDTO) ;
}
