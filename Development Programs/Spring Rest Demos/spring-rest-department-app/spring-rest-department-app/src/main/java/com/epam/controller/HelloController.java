package com.epam.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is based on the old implementation
 */
@RestController
public class HelloController {

    // if value not found default name will come as user
    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping(value = "/user")
    public String helloUser(@RequestParam String username) {
        return welcomeMessage + " " + username;
    }
}
