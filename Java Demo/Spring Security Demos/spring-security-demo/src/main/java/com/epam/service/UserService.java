package com.epam.service;

import com.epam.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> userList;

    public UserService()
    {
        userList = new ArrayList<>();
        userList.add(new User("Jagdish","jagdish@gmail.com","Jagdish@99"));
        userList.add(new User("Admin","admin@gmail.com","Admin@00"));
    }
    public List<User> getAllUsers()
    {
        return this.userList;
    }

    public User getUser(String username)
    {
        return userList.stream()
                        .filter(user->user.getUsername().equals(username))
                        .findAny()
                        .orElse(null);
    }


    public User saveUser(User user)
    {
        this.userList.add(user);
        return user;
    }
}
