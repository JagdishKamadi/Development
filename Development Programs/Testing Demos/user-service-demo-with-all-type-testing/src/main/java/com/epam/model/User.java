package com.epam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "username should not null must contain size between 3 to 10")
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank(message = "password should not null must contain size between 3 to 10")
    @Size(min = 3, max = 20)
    private String password;
    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "user_information_id", nullable = false)
    private UserInformation userInformation;
}
