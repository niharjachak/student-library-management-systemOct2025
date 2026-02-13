package com.acciojob.student_library_management_system.service;

import com.acciojob.student_library_management_system.entities.Book;
import com.acciojob.student_library_management_system.enums.Availability;
import com.acciojob.student_library_management_system.exceptions.BookAlreadyIssuedException;
import com.acciojob.student_library_management_system.exceptions.BookNotFoundException;
import com.acciojob.student_library_management_system.repository.IBookRepository;
import com.acciojob.student_library_management_system.requestdtos.BookRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService {

    @Autowired
    IBookRepository bookRepository;


    public Book saveBook( BookRequestDto bookRequestDto) {
        Book newBook = new Book();

        newBook.setBookName(bookRequestDto.getBookName());
        newBook.setBookPublisher(bookRequestDto.getBookPublisher());;
        newBook.setPublishDate(bookRequestDto.getPublishDate());
        newBook.setPages(bookRequestDto.getPages());
        newBook.setAvailability(Availability.AVAILABLE);
        newBook.setRackNo(bookRequestDto.getRackNo());
        newBook.setCategory(bookRequestDto.getCategory());

        log.info("Saving Book");
        return bookRepository.save(newBook);

    }

    public List<Book> getBooksList(){
        return bookRepository.findAll();
    }

    public String deleteBook(String bookName) {
        Optional<Book> opbook = bookRepository.findByBookName(bookName);
        
        if(opbook.isEmpty()){
            throw new BookNotFoundException("No Book named "+bookName+" found in database!");
        }
        Book book = opbook.get();
        
        if(book.getAvailability()== Availability.ISSUED){
            throw new BookAlreadyIssuedException("Book with Name: "+bookName+ "is issued and hence cannot be Deleted");
        }
        bookRepository.delete(book);
        return "Book Deleted From Database Successfully";
    }

    public List<Book> getAllBooksByAvailability(Availability availability){
        return bookRepository.findByAvailability(availability);
    }

    public Book getBookByBookName(String bookName){
        return bookRepository.findByBookName(bookName).
                orElseThrow(() ->new BookNotFoundException("Book with Name: "+bookName+ " not found"));
    }

}
