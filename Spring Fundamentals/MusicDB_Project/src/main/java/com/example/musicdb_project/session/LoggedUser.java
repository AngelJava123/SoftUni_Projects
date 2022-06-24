package com.example.musicdb_project.session;

import com.example.musicdb_project.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {

    private long id;
    private String username;

    public void logOut() {
        this.id = 0;
        this.username = null;
    }

    public void login(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public LoggedUser() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}