package com.epam.controller;


import com.epam.service.UserService;
import com.epam.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.epam.model.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<ResponseTemplateVO> getUserWithDepartment(@PathVariable("user_id") Integer userId)
    {
        return new ResponseEntity<>(userService.getUserWithDepartment(userId),HttpStatus.FOUND);
    }
}
