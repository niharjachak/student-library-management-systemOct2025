package com.acciojob.student_library_management_system.service;

import com.acciojob.student_library_management_system.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    IBookRepository bookRepository;
}
