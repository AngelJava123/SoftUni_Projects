package com.example.final_project.service;

import com.example.final_project.model.entity.Role;
import com.example.final_project.model.entity.User;
import com.example.final_project.model.user.HerculesUserDetails;
import com.example.final_project.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class HerculesUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public HerculesUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.
                findByUsername(username).
                map(this::map).
                orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));
    }

    private UserDetails map(User user) {

        return new HerculesUserDetails(
                user.getPassword(),
                user.getEmail(),
                user.getFullName(),
                user.getRoles().
                        stream().
                        map(this::map).
                        toList());
    }

    private GrantedAuthority map(Role userRole) {
        return new SimpleGrantedAuthority("ROLE_" +
                userRole.getRole().name());
    }
}
