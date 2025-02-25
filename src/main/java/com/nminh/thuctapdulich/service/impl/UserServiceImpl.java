package com.nminh.thuctapdulich.service.impl;

import com.nminh.thuctapdulich.model.request.UserLoginRequest;
import com.nminh.thuctapdulich.enums.Role;
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
    public boolean userExists(String phone) {
        List<UserEntity> listUserEntity = fileStorageUserImpl.getAllUsers();
        for (UserEntity userEntity : listUserEntity) {
            if (userEntity.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean createUser(UserRequest userRequest) {

        if (userExists(userRequest.getPhone())) {
            return false;
        }
        UserEntity userEntity = new UserEntity();
        // convert user request to user entity
        userEntity.setPhone(userRequest.getPhone());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setFullName(userRequest.getFullName());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setBirthday(userRequest.getBirthday());
        userEntity.setId(ID_Manage.getLastId()); // tao id moi
        userEntity.setRole(Role.GUEST);

        ID_Manage.saveLastId(userEntity.getId()+1L); //luu id moi nhat +1

        fileStorageUserImpl.saveUserToFile(userEntity);

        return true;
    }

    @Override
    public boolean loginUser(UserLoginRequest userDTO) {
        FileStorageUserRepositoryImpl fileStorageUserImpl = new FileStorageUserRepositoryImpl();
        List<UserEntity> listUserEntity = fileStorageUserImpl.getAllUsers();
        for (UserEntity userEntity : listUserEntity) {
            if(userEntity.getPhone().equals(userDTO.getPhone()) && userEntity.getPassword().equals(userDTO.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
