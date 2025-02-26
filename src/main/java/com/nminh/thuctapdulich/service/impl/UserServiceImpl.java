package com.nminh.thuctapdulich.service.impl;

import com.nminh.thuctapdulich.enums.ErrorCode;
import com.nminh.thuctapdulich.exception.AppException;
import com.nminh.thuctapdulich.model.request.UserLoginRequest;
import com.nminh.thuctapdulich.enums.Role;
import com.nminh.thuctapdulich.entity.User;
import com.nminh.thuctapdulich.model.request.UserRequest;
import com.nminh.thuctapdulich.repository.impl.FileStoreUserRepositoryImpl;
import com.nminh.thuctapdulich.repository.impl.ID_Manage;
import com.nminh.thuctapdulich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    FileStoreUserRepositoryImpl fileStorageUserImpl = new FileStoreUserRepositoryImpl();

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

        User user = new User();
        // convert user request to user entity
        user.setPhone(userRequest.getPhone());
        user.setPassword(userRequest.getPassword());
        user.setFullName(userRequest.getFullName());
        user.setEmail(userRequest.getEmail());
        user.setBirthday(userRequest.getBirthday());
        user.setId(ID_Manage.getLastIdUser()); // tao id moi
        user.setRole(Role.GUEST);

        ID_Manage.saveLastIdUser(user.getId()+1L); //luu id moi nhat +1

        fileStorageUserImpl.saveUserToFile(user);

        return user;
    }

    @Override
    public User loginUser(UserLoginRequest userDTO) {
        FileStoreUserRepositoryImpl fileStorageUserImpl = new FileStoreUserRepositoryImpl();
        List<User> listUser = fileStorageUserImpl.getAllUsers(); // lấy toàn bộ danh sách

        for (User user : listUser) {
            if(user.getPhone().equals(userDTO.getPhone()) && user.getPassword().equals(userDTO.getPassword())) {
                return user;
            }
        }
        throw new AppException(ErrorCode.LOGIN_FAILED) ;
    }

}
