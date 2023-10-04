package com.epam.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public ErrorMessage badRequestHandler(RuntimeException runtimeException, WebRequest webRequest)
    {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setError(runtimeException.getMessage());
        errorMessage.setPath(webRequest.getDescription(false));
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorMessage.setTimestamp(LocalDate.now().toString());
        return errorMessage;
    }

    @ExceptionHandler(value = {Exception.class})
    public ErrorMessage globalExceptionHandler(Exception exception,WebRequest webRequest)
    {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setError(exception.getMessage());
        errorMessage.setPath(webRequest.getDescription(false));
        errorMessage.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        errorMessage.setTimestamp(LocalDate.now().toString());
        return errorMessage;
    }
}
