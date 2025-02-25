package com.nminh.thuctapdulich.service;

import com.nminh.thuctapdulich.model.request.UserLoginRequest;
import com.nminh.thuctapdulich.model.request.UserRequest;


public interface  UserService {
    public boolean createUser(UserRequest userRequest) ;
    public boolean loginUser(UserLoginRequest userDTO) ;
}
