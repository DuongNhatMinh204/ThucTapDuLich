package com.nminh.thuctapdulich.entity;

import com.nminh.thuctapdulich.enums.Role;

import java.time.LocalDate;
import java.util.List;

public class User {
    private Long id ;

    private String phone;
    private String password ;
    private String fullName;
    private String email ;
    private LocalDate birthday ;
    private Role role ;

    public User() {}

    public User(Long id, String phone, String password, String fullName, String email, LocalDate birthday, Role role) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.birthday = birthday;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return id+","+phone+","+password+","+fullName+","+email+","+birthday+","+role;
    }
}
