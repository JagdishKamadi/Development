package com.epam.converter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ErrorMessage badRequestHandler(RuntimeException exception, WebRequest request)
    {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setError(exception.getMessage());
        errorMessage.setPath(request.getDescription(false));
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorMessage.setTimestamp(LocalDate.now().toString());
        return errorMessage;
    }

    @ExceptionHandler(Exception.class)
    public ErrorMessage globalRequestHandler(Exception exception, WebRequest request)
    {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setError(exception.getMessage());
        errorMessage.setPath(request.getDescription(false));
        errorMessage.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        errorMessage.setTimestamp(LocalDate.now().toString());
        return errorMessage;
    }
}
