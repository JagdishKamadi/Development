package com.epam.quiz.controller;

import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.service.QuestionService;
import com.epam.quiz.service.SectionService;
import com.epam.quiz.service.UserService;
import com.epam.quiz.utility.cls.DisplayTag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserLoginController {
    @Autowired
    private UserService userService;


    @Operation(summary = "User login API")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "User login successfully", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))}), @ApiResponse(responseCode = "400", description = "Bad request!")})
    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {

        userService.userLogin(userDTO);
        return new ResponseEntity<>("User login successfully", HttpStatus.OK);
    }


    @Operation(summary = "User register API")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "User registered successfully", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))}), @ApiResponse(responseCode = "400", description = "Bad request!")})
    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {

        userService.userAdded(userDTO);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }

}
