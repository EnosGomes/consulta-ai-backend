package com.creta.consultaai.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionsHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorBody> handleException(BusinessException exception){
        return new ResponseEntity<>(
        		new ErrorBody(
        				exception.getStatus().name(), 
        				exception.getStatus().value(), 
        				exception.getMessage()), 
        				exception.getStatus() 
        				);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorBody> handleException(RuntimeException exception){
        return new ResponseEntity<>(
        		new ErrorBody(HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.value(), ""), HttpStatus.BAD_REQUEST);
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    
}

class ErrorBody{
    private String error;
    private int status;
    private String message;

    public ErrorBody(String error, int status, String message) {
        this.error = error;
        this.status = status;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }    
}