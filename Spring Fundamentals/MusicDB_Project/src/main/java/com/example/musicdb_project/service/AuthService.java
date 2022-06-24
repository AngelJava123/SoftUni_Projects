package com.example.musicdb_project.service;

import com.example.musicdb_project.model.User;
import com.example.musicdb_project.model.dto.UserLoginDTO;
import com.example.musicdb_project.model.dto.UserRegisterDTO;
import com.example.musicdb_project.repository.UserRepository;
import com.example.musicdb_project.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public AuthService(UserRepository userRepository,
                       LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    public boolean register(UserRegisterDTO registerDTO) {
        Optional<User> byUsername = this.userRepository.findByUsername(registerDTO.getUsername());

        if (byUsername.isPresent()) {
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(registerDTO.getEmail());

        if (byEmail.isPresent()) {
            return false;
        }

        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            return false;
        }

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setFullName(registerDTO.getFullName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());

        this.userRepository.save(user);

        return true;
    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> user = this.userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if (user.isEmpty()) {
            return false;
        }

        this.loggedUser.login(user.get());

        return true;
    }
}
