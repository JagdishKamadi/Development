package com.epam.quiz.controller;

import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.service.UserService;
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
@RequestMapping(path = "/admin")
public class AdminLoginController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Admin login API")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Admin login successfully", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))}), @ApiResponse(responseCode = "400", description = "Bad request!")})
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> adminLogin(@RequestBody UserDTO userDTO) {
        userService.userLogin(userDTO);
        return new ResponseEntity<>("Admin login successfully", HttpStatus.OK);
    }

}
