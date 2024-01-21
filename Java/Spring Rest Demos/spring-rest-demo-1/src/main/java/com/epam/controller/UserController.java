package com.epam.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping(value="/users")
    public String getUsers()
    {
        return "Getting all users...";
    }

    @GetMapping(value = "/users/{user_id}")
    public String getUser(@PathVariable("user_id") Integer userId)
    {
        return "Found user with id "+userId;
    }

    @DeleteMapping(value = "/users")
    public String deleteUser(@RequestParam("user_id") Integer userId)
    {
        return "Deleted user with id "+userId;
    }
}
