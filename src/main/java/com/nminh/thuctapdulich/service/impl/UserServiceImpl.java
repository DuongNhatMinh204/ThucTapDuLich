package com.nminh.thuctapdulich.service.impl;

import com.nminh.thuctapdulich.enums.ErrorCode;
import com.nminh.thuctapdulich.exception.AppException;
import com.nminh.thuctapdulich.model.request.UserLoginRequest;
import com.nminh.thuctapdulich.enums.Role;
import com.nminh.thuctapdulich.entity.User;
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
        List<User> listUserEntity = fileStorageUserImpl.getAllUsers();
        for (User userEntity : listUserEntity) {
            if (userEntity.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public User createUser(UserRequest userRequest) {

        if (userExists(userRequest.getPhone())) {
            throw new AppException(ErrorCode.USER_EXIST); // nếu tồn tại thì nhả ra exception
        }

        User userEntity = new User();
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

        return userEntity;
    }

    @Override
    public User loginUser(UserLoginRequest userDTO) {
        FileStorageUserRepositoryImpl fileStorageUserImpl = new FileStorageUserRepositoryImpl();
        List<User> listUser = fileStorageUserImpl.getAllUsers(); // lấy toàn bộ danh sách

        for (User user : listUser) {
            if(user.getPhone().equals(userDTO.getPhone()) && user.getPassword().equals(userDTO.getPassword())) {
                return user;
            }
        }
        throw new AppException(ErrorCode.LOGIN_FAILED) ;
    }

}
