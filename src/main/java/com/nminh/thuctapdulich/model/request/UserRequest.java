package com.nminh.thuctapdulich.model.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class UserRequest {
    @Pattern(regexp = "^\\d{10}$",message = "phone must be 10 character")
    private String phone;
    @Size(min=6,max=10)
    private String password;
    @NotBlank
    private String fullName;
    @Email(message = "email invalid format")
    private String email ;
    @NotNull
    private LocalDate birthday ;

    public UserRequest(String phone, String password, String fullName, String email, LocalDate birthday) {
        this.phone = phone;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.birthday = birthday;
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
}
