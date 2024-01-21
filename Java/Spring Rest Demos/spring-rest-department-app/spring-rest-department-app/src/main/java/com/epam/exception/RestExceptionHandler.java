package com.epam.exception;

import com.epam.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {DepartmentNotFoundException.class})
    public ResponseEntity<ErrorMessage> departmentNotFoundExceptionHandler(DepartmentNotFoundException departmentNotFoundException, WebRequest request) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(HttpStatus.NOT_FOUND)
                .path(request.getDescription(false))
                .message(departmentNotFoundException.getMessage())
                .timestamp(LocalDate.now().toString())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
