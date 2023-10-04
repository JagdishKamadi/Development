package com.epam.service;

import com.epam.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
    UserDTO getUser(String username);
    UserDTO addUser(UserDTO userDTO);
    void deleteUser(String username);
    UserDTO updateUser(UserDTO userDTO);
}
