package com.acciojob.student_library_management_system.exceptions;

public class BookAlreadyIssuedException extends RuntimeException{


    public BookAlreadyIssuedException(String message) {
        super(message);
    }
}
