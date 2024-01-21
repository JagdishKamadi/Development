package com.epam.springsecuritydemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/user")
    public ResponseEntity<String> user() {
        return ResponseEntity.status(HttpStatus.OK).body("<h1>Welcome User </h1>");
    }

    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return ResponseEntity.status(HttpStatus.OK).body("<h1>This is just the demo app </h1>");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return ResponseEntity.status(HttpStatus.OK).body("<h1>Welcome Admin </h1>");
    }


}
