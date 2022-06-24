package com.example.shoppinglist_project.service;

import com.example.shoppinglist_project.model.User;
import com.example.shoppinglist_project.model.dto.UserLoginDTO;
import com.example.shoppinglist_project.model.dto.UserRegisterDTO;
import com.example.shoppinglist_project.repository.UserRepository;
import com.example.shoppinglist_project.session.LoggedUser;
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

        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            return false;
        }

        User user = new User();
        user.setUsername(registerDTO.getUsername());
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
