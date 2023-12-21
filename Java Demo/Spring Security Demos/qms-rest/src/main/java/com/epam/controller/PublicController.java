package com.epam.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/public")
public class PublicController {


    @GetMapping
    @PreAuthorize("permitAll()")
    public String home()
    {
        return "This is home page";
    }

    @PostMapping(path="/login")
    @PreAuthorize("permitAll()")
    public String login()
    {
        return "This is login page";
    }

    @PostMapping(path = "/register")
    @PreAuthorize("permitAll()")
    public String register()
    {
        return "This is register page";
    }
}
