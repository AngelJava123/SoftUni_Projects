package com.example.mobilelelele.service;

import com.example.mobilelelele.model.dto.UserLoginDTO;
import com.example.mobilelelele.model.dto.UserRegisterDTO;
import com.example.mobilelelele.model.entity.UserEntity;
import com.example.mobilelelele.repository.UserRepository;
import com.example.mobilelelele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final CurrentUser currentUser;
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       CurrentUser currentUser,
                       PasswordEncoder passwordEncoder) {
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {

        UserEntity newUser = new UserEntity();
        newUser.setActive(true);
        newUser.setUsername(userRegisterDTO.getUserName());
        newUser.setFirstName(userRegisterDTO.getFirstName());
        newUser.setLastName(userRegisterDTO.getLastName());
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        newUser = userRepository.save(newUser);

        login(newUser);
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> result = userRepository.findByUsername(userLoginDTO.getUsername());

        if (result.isEmpty()) {
            LOGGER.info("User with name [{}] not found.", userLoginDTO.getUsername());
            return false;
        }

        var rawPassword = userLoginDTO.getPassword();
        var encodedPassword = result.get().getPassword();

        boolean success = passwordEncoder.matches(
                rawPassword, encodedPassword);

        if (success) {
            login(result.get());
        } else {
            logout();
        }
        return success;
    }

    private void login(UserEntity userEntity) {
        currentUser.setLoggedIn(true);
        currentUser.setName(userEntity.getFirstName() + " " + userEntity.getLastName());
    }

    public void logout() {
        currentUser.clear();
    }
}
