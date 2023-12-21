package com.epam.exception;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException() {
        super("Department not found for this id!");
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
