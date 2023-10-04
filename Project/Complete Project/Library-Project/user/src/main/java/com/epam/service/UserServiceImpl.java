package com.epam.service;

import com.epam.converter.UserConverter;
import com.epam.dto.UserDTO;
import com.epam.exception.UserExistException;
import com.epam.exception.UserNotFoundException;
import com.epam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.epam.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public List<UserDTO> getUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(user -> userConverter.entityToDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(String username) {

        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found for username " + username));
        return userConverter.entityToDTO(user);
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        if (userRepository.findByUsernameAndMailId(userDTO.getUsername(), userDTO.getMailId()) >= 1) {
            throw new UserExistException();
        }
        User user = userRepository.save(userConverter.dtoTOEntity(userDTO));
        return userConverter.entityToDTO(user);
    }

    @Override
    public void deleteUser(String username) {

        if (userRepository.findByUsername(username).isEmpty()) {
            throw new UserNotFoundException("User not found for username " + username);
        }

        Integer id=-1 ;
        if(userRepository.findByUsername(username).isPresent())
        {
            id = userRepository.findByUsername(username).get().getUserId();
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        Optional<User> user1  = Optional.ofNullable(userRepository.findById(userDTO.getUserId()).orElseThrow(() -> new UserNotFoundException("User not found for id " + userDTO.getUserId())));
        User user = userRepository.save(userConverter.dtoTOEntity(userDTO));
        return userConverter.entityToDTO(user);
    }
}
