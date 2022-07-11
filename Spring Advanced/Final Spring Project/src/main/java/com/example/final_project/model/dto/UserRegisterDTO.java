package com.example.final_project.model.dto;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.math.BigDecimal;

public class UserRegisterDTO {

    @NotNull
    @Size(min = 5, max = 20)
    @Column(unique = true)
    private String username;

    private String fullName;

    @Min(18)
    @NotNull
    private int age;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @Positive
    @NotNull
    private BigDecimal wallet;

    @NotNull
    @Size(min = 5)
    private String password;

    @NotNull
    @Size(min = 5)
    private String confirmPassword;

    public UserRegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getWallet() {
        return wallet;
    }

    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
