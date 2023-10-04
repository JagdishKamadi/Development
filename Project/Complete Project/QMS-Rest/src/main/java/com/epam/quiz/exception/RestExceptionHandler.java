package com.epam.quiz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage badRequestHandler(RuntimeException runtimeException, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorMessage.setPath(request.getDescription(false));
        errorMessage.setError(runtimeException.getMessage());
        errorMessage.setTimestamp(LocalDate.now().toString());
        return errorMessage;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(Exception exception,WebRequest request)
    {
        return new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                request.getDescription(false),
                exception.getMessage(),
                LocalDate.now().toString());
    }

}
