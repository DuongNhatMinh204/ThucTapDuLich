package com.nminh.thuctapdulich.service;

import com.nminh.thuctapdulich.model.request.UserRequest;
import com.nminh.thuctapdulich.model.response.UserResponse;
import org.springframework.stereotype.Service;


public interface  UserService {
    public boolean createUser(UserRequest userRequest) ;
    public boolean loginUser(UserRequest userRequest) ;
}
