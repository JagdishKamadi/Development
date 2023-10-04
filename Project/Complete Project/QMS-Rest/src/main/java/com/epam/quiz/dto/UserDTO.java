package com.epam.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotNull
    @Size(min = 5, max = 20 ,message = "Username should have 5 or more character")
    private String username;

    @NotNull
    @Size(min=10,message="Mail should contain at least 10 character")
    @Column(name="mail_id")
    private String mailId;

    @NotNull
    @Size(min = 5, max = 20 ,message = "Password should have 5 or more character")
    private String password;

    private String role;
}
