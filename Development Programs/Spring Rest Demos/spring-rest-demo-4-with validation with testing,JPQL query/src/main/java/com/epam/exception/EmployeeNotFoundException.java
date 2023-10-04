package com.epam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// we can do also use following way
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException()
    {
        super("Employee not found!");
    }

    public EmployeeNotFoundException(String str)
    {
        super(str);
    }
}
