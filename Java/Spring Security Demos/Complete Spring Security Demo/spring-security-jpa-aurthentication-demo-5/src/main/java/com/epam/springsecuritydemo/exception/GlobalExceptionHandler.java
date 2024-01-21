package com.epam.springsecuritydemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseMessage UserNotFoundExceptionHandler(UserNotFoundException exception, WebRequest request) {
        return  ResponseMessage.builder()
                .error(exception.getMessage())
                .path(request.getDescription(false))
                .timestamp(LocalDate.now().toString())
                .status(HttpStatus.NOT_FOUND.toString())
                .build();

    }
}
