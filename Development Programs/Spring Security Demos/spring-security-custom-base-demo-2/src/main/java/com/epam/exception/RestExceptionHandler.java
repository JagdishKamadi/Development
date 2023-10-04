package com.epam.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
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

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("timestamp",LocalDate.now());
        body.put("status",status);

        // now put all error in list
        List<String> errors =ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        body.put("errors",errors);
        return new  ResponseEntity<>(body,status);
    }

    @ExceptionHandler(value = {EmployeeNotFoundException.class})
    public ResponseEntity<ErrorMessage> employeeNotFoundExceptionHandler(EmployeeNotFoundException exception, WebRequest webRequest)
    {
        ErrorMessage  errorMessage = ErrorMessage.builder()
                .timestamp(LocalDate.now().toString())
                .status(HttpStatus.NOT_FOUND.toString())
                .path(webRequest.getDescription(false))
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }

}
