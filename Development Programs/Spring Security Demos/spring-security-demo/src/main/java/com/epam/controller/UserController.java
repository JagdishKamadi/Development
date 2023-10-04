package com.epam.controller;

import com.epam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.epam.model.*;

import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public User getUser(@PathVariable("username") String username)
    {
        return userService.getUser(username);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public User saveUser(User user)
    {
        return userService.saveUser(user);
    }
}
