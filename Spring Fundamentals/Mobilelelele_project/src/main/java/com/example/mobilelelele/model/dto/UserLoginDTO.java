package com.example.mobilelelele.model.dto;

import java.util.StringJoiner;

public class UserLoginDTO {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserLoginDTO.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("password='" + (password != null ? "[PROVIDED]" : null) + "'")
                .toString();
    }
}
