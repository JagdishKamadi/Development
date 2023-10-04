package com.epam.controller;

import com.epam.dto.UserDTO;
import com.epam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers()
    {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO>  getUser(@PathVariable("username") String username)
    {
        return new ResponseEntity<>(userService.getUser(username),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO)
    {
        return new ResponseEntity<>(userService.addUser(userDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable("username") String username)
    {
        userService.deleteUser(username);
        return new ResponseEntity<>("User deleted successfully for username "+username,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO)
    {
        return new ResponseEntity<>(userService.updateUser(userDTO),HttpStatus.OK);
    }
}
