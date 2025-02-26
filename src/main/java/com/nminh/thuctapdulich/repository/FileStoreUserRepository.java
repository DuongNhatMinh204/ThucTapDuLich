package com.nminh.thuctapdulich.repository;

import com.nminh.thuctapdulich.entity.User;

import java.util.List;

public interface FileStoreUserRepository {
    public void saveUserToFile( User userEntity);
    public List<User> getAllUsers();
}
