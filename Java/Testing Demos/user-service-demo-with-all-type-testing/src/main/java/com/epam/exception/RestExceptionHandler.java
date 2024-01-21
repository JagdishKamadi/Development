package com.epam.exception;

import com.epam.model.ErrorResponseMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ErrorResponseMessage userNotFoundExceptionHandler(UserNotFoundException e, WebRequest request) {
        ErrorResponseMessage errorResponseMessage = ErrorResponseMessage.builder()
                .path(request.getDescription(false))
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .localDate(LocalDate.now())
                .build();

        return errorResponseMessage;
    }

    @ExceptionHandler(value = {UserExistException.class})
    public ErrorResponseMessage userExistExceptionHandler(UserExistException e, WebRequest request) {
        ErrorResponseMessage errorResponseMessage = ErrorResponseMessage.builder()
                .path(request.getDescription(false))
                .message(e.getMessage())
                .status(HttpStatus.FOUND)
                .localDate(LocalDate.now())
                .build();

        return errorResponseMessage;
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponseMessage globalUserExceptionHandler(Exception e, WebRequest request) {
        ErrorResponseMessage errorResponseMessage = ErrorResponseMessage.builder()
                .path(request.getDescription(false))
                .message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .localDate(LocalDate.now())
                .build();

        return errorResponseMessage;
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseMessage runtimeExceptionHandler(RuntimeException e, WebRequest request) {
        ErrorResponseMessage errorResponseMessage = ErrorResponseMessage.builder()
                .path(request.getDescription(false))
                .message(e.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .localDate(LocalDate.now())
                .build();

        return errorResponseMessage;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", status);

        // now put all error in list
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        body.put("errors", errors);

        return new ResponseEntity<>(body, status);
    }
}
