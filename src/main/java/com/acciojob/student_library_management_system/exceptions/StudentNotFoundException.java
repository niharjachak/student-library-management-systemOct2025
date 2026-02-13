package com.acciojob.student_library_management_system.exceptions;

import com.acciojob.student_library_management_system.entities.Student;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String message) {
        super(message);
    }
}
