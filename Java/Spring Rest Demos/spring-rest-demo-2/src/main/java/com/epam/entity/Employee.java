package com.epam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @JsonProperty(value = "full_name")
    private String name;
    private Integer age;
    private String location;

    // if you apply this you will not get email in response body
    @JsonIgnore
    private String email;
    private String department;
}
