package com.epam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Email
    @NotBlank(message = "email should not be null size must greater than 10")
    @Size(min = 10)
    private String email;

    @Pattern(regexp = "[\\d]{10}", message = "phone number field should contain 10 digits!")
    private String phoneNumber;

    @NotBlank
    @Size(min = 6, max = 10, message = "Date of birth should be in valid format")
    private String dateOfBirth;

}
