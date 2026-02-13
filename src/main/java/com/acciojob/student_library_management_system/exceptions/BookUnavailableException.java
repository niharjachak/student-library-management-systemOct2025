package com.acciojob.student_library_management_system.exceptions;

public class BookUnavailableException extends RuntimeException {
    public BookUnavailableException(String message) {
        super(message);
    }
}
