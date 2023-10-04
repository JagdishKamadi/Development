package com.epam.departmentservice.exception;

public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException() {
        super("Department not found!");
    }

    public DepartmentNotFoundException(String str)
    {
        super(str);
    }
}
