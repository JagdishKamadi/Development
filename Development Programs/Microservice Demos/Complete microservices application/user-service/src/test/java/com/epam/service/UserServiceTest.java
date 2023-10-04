package com.epam.service;

import com.epam.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.model.*;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    @BeforeEach
    void setUp() {
        user = new User();
        user.setFirstName("Jagdish");
        user.setLastName("Kamadi");
        user.setEmailId("jagadishkamadi@gmail.com");
        user.setDepartmentId(1);
    }

    @Test
    void test_saveUser_success() {
        Mockito.when(userRepository.save(user)).thenReturn(user);
        assertNotNull(userService.saveUser(user));
    }

    @Test
    void getUser() {
    }
}