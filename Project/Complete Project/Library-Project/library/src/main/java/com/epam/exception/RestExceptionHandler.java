//package com.epam.exception;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import feign.FeignException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//
//import java.time.LocalDate;
//
//@RestControllerAdvice
//public class RestExceptionHandler {
//    @ExceptionHandler(value = {FeignException.class})
//    public ResponseEntity<ErrorMessage> handle(FeignException exception, WebRequest request) throws JsonProcessingException {
//        ErrorMessage errorMessage = new ErrorMessage();
//        errorMessage.setError(exception.getMessage());
//        errorMessage.setPath(request.getDescription(false));
//        errorMessage.setStatus(HttpStatus.BAD_REQUEST.toString());
//        errorMessage.setTimestamp(LocalDate.now().toString());
//        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
//    }
//}
