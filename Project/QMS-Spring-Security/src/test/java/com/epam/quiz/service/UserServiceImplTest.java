package com.epam.quiz.service;

import com.epam.quiz.converter.UserConverter;
import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.exception.UserExistException;
import com.epam.quiz.exception.UserNotFoundException;
import com.epam.quiz.model.User;
import com.epam.quiz.repository.UserRepository;
import com.epam.quiz.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
    void test_userLoginValid()
    {
        userRepository.findByUsernameAndPasswordAndTypeOfUser(userDTO.getUsername(),userDTO.getMailId(),userDTO.getTypeOfUser());
        verify(userRepository).findByUsernameAndPasswordAndTypeOfUser(userDTO.getUsername(),userDTO.getMailId(),userDTO.getTypeOfUser());
        verify(userRepository,times(1)).findByUsernameAndPasswordAndTypeOfUser(userDTO.getUsername(),userDTO.getMailId(),userDTO.getTypeOfUser());
    }

    @Test
    void test_userLoginInvalid()
    {
       assertThrows(UserNotFoundException.class,()->userService.userLogin(userDTO));
    }

    @Test
    void test_userAddedSuccess()
    {
        userRepository.save(user);
        verify(userRepository).save(user);
        verify(userRepository,times(1)).save(user);
    }

    @Test
    void test_userAddedError()
    {
        when(userRepository.findByUsernameOrMailid(userDTO.getUsername(), userDTO.getMailId())).thenReturn(1);
        assertThrows(UserExistException.class,()->userService.userAdded(userDTO));
    }
}
