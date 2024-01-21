package com.epam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage userNotFoundExceptionHandler(UserNotFoundException exception, WebRequest request)
    {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setError(exception.getMessage());
        errorMessage.setPath(request.getDescription(false));
        errorMessage.setHttpStatus(HttpStatus.NOT_FOUND);
        errorMessage.setTimestamp(LocalDate.now());
        return errorMessage;
    }

    @ExceptionHandler(value = {Exception.class})
    public ErrorMessage internalExceptionHandler(Exception exception, WebRequest request)
    {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setError(exception.getMessage());
        errorMessage.setPath(request.getDescription(false));
        errorMessage.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        errorMessage.setTimestamp(LocalDate.now());
        return errorMessage;
    }

}
