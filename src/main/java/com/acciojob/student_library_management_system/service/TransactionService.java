package com.acciojob.student_library_management_system.service;

import com.acciojob.student_library_management_system.entities.Book;
import com.acciojob.student_library_management_system.entities.Card;
import com.acciojob.student_library_management_system.entities.Transaction;
import com.acciojob.student_library_management_system.enums.Availability;
import com.acciojob.student_library_management_system.enums.CardStatus;
import com.acciojob.student_library_management_system.enums.TransactionType;
import com.acciojob.student_library_management_system.exceptions.*;
import com.acciojob.student_library_management_system.repository.IBookRepository;
import com.acciojob.student_library_management_system.repository.ICardRepository;
import com.acciojob.student_library_management_system.repository.IStudentRepository;
import com.acciojob.student_library_management_system.repository.ITransactionRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private ITransactionRepository transactionRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private ICardRepository cardRepository;

    @Autowired
    private StudentService studentService;


    @Transactional
    public Transaction borrowBook (String bookName, String studEmail) {

        UUID studentCardId= studentService.getStudentCardIDByEmail(studEmail);
        Book book = bookService.getBookByBookName(bookName);

        if(book.getAvailability()!= Availability.AVAILABLE){
            throw new BookUnavailableException(book.getBookName()+" is Unavailable! Please try Later");
        }
        //CardStatus check
        Card card = cardRepository.findById(studentCardId).orElseThrow(()-> new RuntimeException("Card Not Found"));
        if(card.getCardStatus()!= CardStatus.ACTIVE){
            throw new CardInactiveException("Card is INACTIVE!");
        }

        //Assign book to Card
        book.setCard(card);
        //set its availability to issued
        book.setAvailability(Availability.ISSUED);

        bookRepository.save(book);
        log.info("Book Issued Succesfully");

        Transaction transaction= new Transaction();

        transaction.setTransactionDate(LocalDate.now());
        transaction.setTransactionType(TransactionType.BORROW);
        transaction.setDueDate(LocalDate.now().plusDays(14));
        transaction.setBook(book);
        transaction.setCard(card);

        transactionRepository.save(transaction);
        log.info("Transaction with Id: "+transaction.getTransactionId()+" successfull");
        return transaction;

    }

    @Transactional
    public Transaction returnBook(String bookName, String studentEmail){

        UUID studentCardId= studentService.getStudentCardIDByEmail(studentEmail);
        Book book = bookService.getBookByBookName(bookName);

        Card card = cardRepository.findById(studentCardId)
                .orElseThrow(
                        ()-> new InvalidCardException("INVALID  CARD-ID")
                );


        if(book.getAvailability()!=Availability.ISSUED){
            throw new BookException("BOOK :"+bookName+" IS NOT ISSUED");
        }
        if (book.getCard()==null){
            throw new BookException("THE BOOK IS NOT ISSUED TO ANY CARD-ID");
        }
        // THE  CARD THIS BOOK IS ASSIGNED TO
            UUID bookCardId= book.getCard().getCardId();

        if( !bookCardId.equals(studentCardId)  ){
            throw new BookException("BOOK "+bookName+" IS NOT ISSUED BY STUDENT !");
        }

        book.setAvailability(Availability.AVAILABLE);
        book.setCard(null);

        Transaction transaction = new Transaction();
        transaction.setTransactionDate(LocalDate.now());
        transaction.setTransactionType(TransactionType.RETURN);
        transaction.setBook(book);
        transaction.setCard(card);

        bookRepository.save(book);
        log.info("RETURN TRANSACTION SUCCESSFUL!");
        return transactionRepository.save(transaction);

    }


}
