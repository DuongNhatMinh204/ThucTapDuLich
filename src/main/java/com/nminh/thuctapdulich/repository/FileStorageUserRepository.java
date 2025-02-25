package com.nminh.thuctapdulich.repository;

import com.nminh.thuctapdulich.entity.UserEntity;

import java.util.List;

public interface FileStorageUserRepository {
    public void saveUserToFile( UserEntity userEntity);
    public List<UserEntity> getAllUsers();
}
