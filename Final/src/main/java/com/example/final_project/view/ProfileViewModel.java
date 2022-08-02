package com.example.final_project.view;

import java.math.BigDecimal;

public class ProfileViewModel {

    private String username;
    private String fullName;
    private int age;
    private String email;
    private BigDecimal wallet;

    public ProfileViewModel() {
    }

    public String getImageUrl() {
        return "images/profile.jpg";
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
}
