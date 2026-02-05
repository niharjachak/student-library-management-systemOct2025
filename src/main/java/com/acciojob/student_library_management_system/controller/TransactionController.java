package com.acciojob.student_library_management_system.controller;

import com.acciojob.student_library_management_system.entities.Transaction;
import com.acciojob.student_library_management_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lms/apis/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/borrowBook")
    public Transaction borrowBook(
            @RequestParam String bookName,
            @RequestParam String studentEmail
    ){
        return transactionService.borrowBook(bookName,studentEmail);
    }


    @PostMapping("/returnBook")
    public Transaction returnBook(
            @RequestParam String bookName,
            @RequestParam String studentEmail
    ){
        return transactionService.returnBook(bookName,studentEmail);
    }

}
