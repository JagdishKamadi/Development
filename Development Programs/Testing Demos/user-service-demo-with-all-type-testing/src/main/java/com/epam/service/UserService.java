package com.epam.service;

import com.epam.model.User;

import java.util.List;

public interface UserService {

    User getUser(String username);

    List<User> getUsers();

    User save(User user);

    void delete(String username);
}
