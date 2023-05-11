package com.Spring.Spring.Exeption;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;


@ControllerAdvice
public class AppExceptionHandler  extends ResponseEntityExceptionHandler {

    /* patient not exist */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(){
        String error = "Patient does not exist";
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND,error);
        return buildResponseEntity(response);
    }

    /* duplicates id's not allowed */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> ConstraintViolationException() {
        String error = "Id is already exist: ";
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST, error);
        return buildResponseEntity(response);
    }

    /* incorrect data type when insert entity */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleIntegrityViolationException(DataIntegrityViolationException ex){
        String error = "Data type not allowed: " + ex.getMostSpecificCause();
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST,error);
        return buildResponseEntity(response);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
        return new ResponseEntity<>(errorResponse,errorResponse.getStatus());
    }
}
