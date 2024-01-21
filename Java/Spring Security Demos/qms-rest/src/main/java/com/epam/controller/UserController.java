package com.epam.controller;

import com.epam.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.epam.model.*;

import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<User> getUsers()
    {
        return userServiceImpl.getAllUser();
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public User getUser(@PathVariable("username") String username)
    {
        return userServiceImpl.getUser(username);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public User saveUser(@RequestBody User user)
    {
        return userServiceImpl.saveUser(user);
    }
}
