package com.example.final_project.service;

import com.example.final_project.model.entity.Role;
import com.example.final_project.model.entity.User;
import com.example.final_project.model.enums.RoleEnum;
import com.example.final_project.model.user.HerculesUserDetails;
import com.example.final_project.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HerculesUserDetailsServiceTest {

    @Mock
    private UserRepository mockUserRepo;

    private HerculesUserDetailsService toTest;

    @BeforeEach
    void setUp() {
        toTest = new HerculesUserDetailsService(
                mockUserRepo
        );
    }

    @Test
    void testLoadUserByUsername_UserExists() {
        // arrange
        User testUser = new User();
        testUser.setEmail("angel@example.com");
        testUser.setPassword("121212");
        testUser.setUsername("angelVtashev");
        testUser.setFullName("AngelTashev");
        testUser.setAge(21);
        testUser.setWallet(BigDecimal.valueOf(300));

        Set<Role> roles = new HashSet<>();
        Role admin = new Role();
        Role user = new Role();
        admin.setRole(RoleEnum.ADMIN);
        user.setRole(RoleEnum.USER);
        roles.add(admin);
        roles.add(user);

        testUser.setRoles(roles);

        when(mockUserRepo.findByEmail(testUser.getEmail())).
                thenReturn(Optional.of(testUser));

        // act
        HerculesUserDetails userDetails = (HerculesUserDetails)
                toTest.loadUserByUsername(testUser.getEmail());

        // assert
        Assertions.assertEquals(testUser.getEmail(), userDetails.getUsername());
        Assertions.assertEquals(testUser.getFullName(), userDetails.getFullName());
        Assertions.assertEquals(testUser.getPassword(), userDetails.getPassword());

        var authorities = userDetails.getAuthorities();

        Assertions.assertEquals(2, authorities.size());

        var authoritiesIter = authorities.iterator();

        Assertions.assertEquals("ROLE_" + RoleEnum.USER.name(),
                authoritiesIter.next().getAuthority());
        Assertions.assertEquals("ROLE_" + RoleEnum.ADMIN.name(),
                authoritiesIter.next().getAuthority());
    }

    @Test
    void testLoadUserByUsername_UserDoesNotExist() {

        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> toTest.loadUserByUsername("non-existant@example.com")
        );
    }
}
