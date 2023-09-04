package com.controllerstechiteasy.techiteasycontrolleropdracht.exceptions;

public class RecordNotFoundException extends RuntimeException {

    //create default exception
    public RecordNotFoundException() {
        super();
    }

    //create default with a message
    public RecordNotFoundException(String message) {
        super(message);
    }
}
