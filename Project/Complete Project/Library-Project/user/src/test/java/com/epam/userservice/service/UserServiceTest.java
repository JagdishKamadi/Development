package com.epam.userservice.service;

import com.epam.converter.UserConverter;
import com.epam.dto.UserDTO;
import com.epam.exception.UserExistException;
import com.epam.exception.UserNotFoundException;
import com.epam.repository.UserRepository;
import com.epam.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.model.*;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserConverter userConverter;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    private UserDTO userDTO;
    private User user;


    @BeforeEach
    void setUpObject()
    {
        userDTO = new UserDTO();
        userDTO.setUserId(1);
        userDTO.setUsername("Jagdish");
        userDTO.setMailId("jagadishkamadi@gmail.com");
        userDTO.setPassword("Jagdish@99");

        user = new User();
        user.setUserId(1);
        user.setUsername("Jagdish");
        user.setMailId("jagadishkamadi@gmail.com");
        user.setPassword("Jagdish@99");
    }

    @Test
    void test_getUsers()
    {
        when(userRepository.findAll()).thenReturn(new ArrayList<User>());
        assertNotNull(userServiceImpl.getUsers());
    }

    @Test
    void test_getUserSuccess()
    {
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(user));
        when(userConverter.entityToDTO(any(User.class))).thenReturn(userDTO);
        assertNotNull(userServiceImpl.getUser(anyString()));
    }

    @Test
    void test_getUsersError()
    {
        assertThrows(UserNotFoundException.class,()->userServiceImpl.getUser(anyString()));
    }

    @Test
    void test_addUserSuccess()
    {
        when(userRepository.findByUsernameAndMailId(anyString(), anyString())).thenReturn(0);
        when(userConverter.dtoTOEntity(any(UserDTO.class))).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userConverter.entityToDTO(any(User.class))).thenReturn(userDTO);
        assertNotNull(userServiceImpl.addUser(userDTO));
    }

    @Test
    void test_addUserError()
    {
        when(userRepository.findByUsernameAndMailId(anyString(), anyString())).thenReturn(2);
        assertThrows(UserExistException.class,()->userServiceImpl.addUser(userDTO));
    }

    @Test
    void test_deleteUserSuccess()
    {
        userRepository.deleteById(anyInt());
        verify(userRepository).deleteById(anyInt());
        verify(userRepository,times(1)).deleteById(anyInt());
    }

    @Test
    void test_deleteUserError()
    {
       assertThrows(UserNotFoundException.class,()->userServiceImpl.deleteUser(anyString()));
    }

    @Test
    void test_updateUserSuccess()
    {
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));
        when(userConverter.dtoTOEntity(any(UserDTO.class))).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userConverter.entityToDTO(any(User.class))).thenReturn(userDTO);
        assertNotNull(userServiceImpl.updateUser(userDTO));
    }
}
