package com.epam.springsecuritydemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TestController {

    @GetMapping("/{name}")
    public ResponseEntity<String> getAppInfo(@PathVariable String name)
    {
        return ResponseEntity.status(HttpStatus.OK).body("<h1>Welcome "+name+" </h1>");
    }


}
