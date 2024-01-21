package com.epam.service;

import com.epam.exception.UserExistException;
import com.epam.exception.UserNotFoundException;
import com.epam.model.User;
import com.epam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found for username " + username));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        if (!isUserExist(user.getUsername())) {
            user = userRepository.save(user);
        } else {
            throw new UserExistException("User already exits for username " + user.getUsername());
        }
        return user;
    }

    @Override
    @Transactional
    @Modifying
    public void delete(String username) {

        userRepository.deleteByUsername(username);
    }

    private boolean isUserExist(String username) {
        return StringUtils.isEmpty(username);
    }
}
