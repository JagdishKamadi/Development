package com.epam.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @NotBlank(message = "First name is required")
    @Size(min = 1,max=25,message = "The firstname should have length between 1 and 25 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 1,max=25,message = "The lastname should have length between 1 and 25 characters")
    private String lastName;


    @Range(min = 1,max = 120,message = "Please select the age between 1 to 120 years")
    private Integer age;
}
