package com.epam.quiz.service;

import com.epam.quiz.converter.UserConverter;
import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.model.User;
import com.epam.quiz.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/* Completed all test case */
@ExtendWith(MockitoExtension.class)
 class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserConverter userConverter;

    @InjectMocks
    private UserServiceImpl userService;

    private UserDTO userDTO;
    private User user;

    @BeforeEach
    void setUpObject()
    {
        userDTO = new UserDTO();
        userDTO.setUsername("Jagdish");
        userDTO.setTypeOfUser(2);
        userDTO.setPassword("Jagdish@99");
        userDTO.setMailId("jagadishkamadi@gmail.com");

        user = new User();
        user.setUsername("Jagdish");
        user.setTypeOfUser(2);
        user.setPassword("Jagdish@99");
        user.setMailId("jagadishkamadi@gmail.com");
    }

    @Test
    void isUserLoginPassTest()
    {

        when(userRepository.findByUsernameAndPasswordAndTypeOfUser(userDTO.getUsername(), userDTO.getPassword(),userDTO.getTypeOfUser())).thenReturn(Optional.of(user));
        assertTrue(userService.isUserLogin(userDTO));
    }

    @Test
    void isUserLoginFailTest()
    {


        when(userRepository.findByUsernameAndPasswordAndTypeOfUser(userDTO.getUsername(), userDTO.getPassword(),userDTO.getTypeOfUser())).thenReturn(Optional.empty());
        assertFalse(userService.isUserLogin(userDTO));
    }

    @Test
    void isAddedUserPassTest()
    {

        when(userRepository.findByUsernameOrMailid(userDTO.getUsername(), userDTO.getMailId())).thenReturn(0);
        when(userConverter.convertDTOToEntity(userDTO)).thenReturn(user);
        assertTrue(userService.isAddedUser(userDTO));
    }

    @Test
    void isAddedUserFailTest()
    {

        when(userRepository.findByUsernameOrMailid(userDTO.getUsername(), userDTO.getMailId())).thenReturn(2);
        when(userConverter.convertDTOToEntity(userDTO)).thenReturn(user);
        assertFalse(userService.isAddedUser(userDTO));
    }


}
