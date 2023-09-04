package com.controllerstechiteasy.techiteasycontrolleropdracht.controllers;

import exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {

    //exception handler
    @ExceptionHandler(value = exceptions.RecordNotFoundException.class)
    public ResponseEntity<String> exception(RecordNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
