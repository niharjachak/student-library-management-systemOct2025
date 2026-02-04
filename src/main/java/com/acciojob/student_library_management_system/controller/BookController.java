package com.acciojob.student_library_management_system.controller;

import com.acciojob.student_library_management_system.entities.Book;
import com.acciojob.student_library_management_system.enums.Availability;
import com.acciojob.student_library_management_system.requestdtos.BookRequestDto;
import com.acciojob.student_library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lms/apis/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody  BookRequestDto bookRequestDto){
        return bookService.saveBook(bookRequestDto);
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook(@RequestParam String bookName) {
        return bookService.deleteBook(bookName);
    }


    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return bookService.getBooksList();
    }

    @GetMapping("/getAllBooksByAvailability/{availability}")
    public List<Book> getBooksByAvailability(@PathVariable  Availability availability){
        return bookService.getAllBooksByAvailability(availability);
    }





}
