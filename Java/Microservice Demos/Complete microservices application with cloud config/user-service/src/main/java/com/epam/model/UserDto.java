package com.epam.model;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserDto implements Serializable {
    private final Integer userId;
    private final String firstName;
    private final String lastName;
    private final String emailId;
    private final Integer departmentId;
}