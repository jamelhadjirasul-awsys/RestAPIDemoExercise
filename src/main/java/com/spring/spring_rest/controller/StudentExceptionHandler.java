package com.spring.spring_rest.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.spring.spring_rest.entity.StudentErrorResponse;
import com.spring.spring_rest.exception.StudentNotFoundException;

/**
 * Converts student and request validation exceptions into HTTP responses.
 */
@ControllerAdvice 
public class StudentExceptionHandler {

    /**
     * Builds a not-found response for a missing student.
     *
     * @param ex exception describing the missing student
     * @return a not-found response with the error details
     */
    @ExceptionHandler 
    public ResponseEntity<StudentErrorResponse> handleException (
            StudentNotFoundException ex) {

        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ex.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
    
    /**
     * Builds a bad-request response for other request errors.
     *
     * @param ex exception raised while handling the request
     * @return a bad-request response
     */
    @ExceptionHandler 
    public ResponseEntity<StudentErrorResponse> handleException (Exception ex) 
    {
        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage("Invalid data. Only integers are accepted");
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    /**
     * Returns field validation messages for invalid request data.
     *
     * @param ex validation exception containing field errors
     * @return a map of field names to validation messages
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException (
            MethodArgumentNotValidException ex) {
        Map<String, String> err = new HashMap<>();
    
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            err.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }    
}
