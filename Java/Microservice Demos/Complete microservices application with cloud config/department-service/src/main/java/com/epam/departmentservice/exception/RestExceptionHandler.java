package com.epam.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ErrorMessage departmentNotFoundExceptionHandler(DepartmentNotFoundException exception, WebRequest request)
    {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .error(exception.getMessage())
                .path(request.getDescription(false))
                .status(HttpStatus.NOT_FOUND.toString())
                .timestamp(LocalDate.now().toString())
                .build();

        return errorMessage;
    }

    @ExceptionHandler(Exception.class)
    public ErrorMessage internalExceptionHandlerHandler(Exception exception, WebRequest request)
    {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .error(exception.getMessage())
                .path(request.getDescription(false))
                .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .timestamp(LocalDate.now().toString())
                .build();

        return errorMessage;
    }
}
