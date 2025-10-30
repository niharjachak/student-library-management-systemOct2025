package com.acciojob.student_library_management_system.entities;

import com.acciojob.student_library_management_system.enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="transactions")
public class Transaction {

    //-> id, transactionDate, dueDate, transactionType(BORROW or RETURN).

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int transactionId;

    @CreationTimestamp
    @Column(nullable = false)
    private Date transactionDate;

    @Column(nullable = false)
    private String dueDate;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    @JoinColumn   // adds the PK bookId of Book as a FK to the Transaction table
    @ManyToOne
    private Book book;

    @JoinColumn   // adds the PK cardId of Card as a FK to the Transaction table
    @ManyToOne
    private Card card;


    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
