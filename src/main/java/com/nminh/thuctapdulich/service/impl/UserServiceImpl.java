package com.nminh.thuctapdulich.service.impl;

import com.nminh.thuctapdulich.emuns.Role;
import com.nminh.thuctapdulich.entity.UserEntity;
import com.nminh.thuctapdulich.model.request.UserRequest;
import com.nminh.thuctapdulich.repository.impl.FileStorageUserRepositoryImpl;
import com.nminh.thuctapdulich.repository.impl.ID_Manage;
import com.nminh.thuctapdulich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    FileStorageUserRepositoryImpl fileStorageUserImpl = new FileStorageUserRepositoryImpl();
    public boolean userExists(String username) {
        List<UserEntity> listUserEntity = fileStorageUserImpl.getAllUsers();
        for (UserEntity userEntity : listUserEntity) {
            if (userEntity.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean createUser(UserRequest userRequest) {

        if (userExists(userRequest.getUsername())) {
            return false;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRequest.getUsername());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setId(ID_Manage.getLastId()); // tao id moi
        userEntity.setRole(Role.GUEST);

        ID_Manage.saveLastId(userEntity.getId()+1L); //luu id moi nhat +1

        fileStorageUserImpl.saveUserToFile(userEntity);

        return true;
    }

    @Override
    public boolean loginUser(UserRequest userRequest) {
        FileStorageUserRepositoryImpl fileStorageUserImpl = new FileStorageUserRepositoryImpl();
        List<UserEntity> listUserEntity = fileStorageUserImpl.getAllUsers();
        for (UserEntity userEntity : listUserEntity) {
            if(userEntity.getUsername().equals(userRequest.getUsername()) && userEntity.getPassword().equals(userRequest.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
