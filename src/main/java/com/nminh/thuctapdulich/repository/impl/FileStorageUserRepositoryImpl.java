package com.nminh.thuctapdulich.repository.impl;

import com.nminh.thuctapdulich.emuns.Role;
import com.nminh.thuctapdulich.entity.UserEntity;
import com.nminh.thuctapdulich.repository.FileStorageUserRepository;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
@Repository
public class FileStorageUserRepositoryImpl implements FileStorageUserRepository {
    private static final String FILE_USER = "user.txt";
    @Override
    public  void saveUserToFile( UserEntity userEntity) {
        try(FileWriter writer = new FileWriter(FILE_USER, true)) { // true : viet them
            writer.write(userEntity.toString());
            writer.write("\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = new ArrayList<>();
        try(FileReader reader = new FileReader(FILE_USER)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                UserEntity userEntity = new UserEntity();

                userEntity.setId(Long.valueOf(data[0]));
                userEntity.setUsername(data[1]);
                userEntity.setPassword(data[2]);
                userEntity.setRole(Role.valueOf(data[3]));

                users.add(userEntity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users ;
    }
}
