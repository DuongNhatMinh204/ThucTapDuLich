package com.nminh.thuctapdulich.repository.impl;

import com.nminh.thuctapdulich.enums.Role;
import com.nminh.thuctapdulich.entity.User;
import com.nminh.thuctapdulich.repository.FileStorageUserRepository;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
public class FileStorageUserRepositoryImpl implements FileStorageUserRepository {
    private static final String FILE_USER = "user.txt";
    @Override
    public  void saveUserToFile( User userEntity) {
        try(FileWriter writer = new FileWriter(FILE_USER, true)) { // true : viet them
            writer.write(userEntity.toString());
            writer.write("\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try(FileReader reader = new FileReader(FILE_USER)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                User userEntity = new User();

                userEntity.setId(Long.valueOf(data[0]));
                userEntity.setPhone(data[1]);
                userEntity.setPassword(data[2]);
                userEntity.setFullName(data[3]);
                userEntity.setEmail(data[4]);
                userEntity.setBirthday(LocalDate.parse(data[5]));
                userEntity.setRole(Role.valueOf(data[6]));

                users.add(userEntity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users ;
    }
}
