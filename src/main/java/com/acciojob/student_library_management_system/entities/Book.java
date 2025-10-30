package com.acciojob.student_library_management_system.entities;

import com.acciojob.student_library_management_system.enums.Category;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private int bookId;

    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private String bookPublisher;

    @Column(nullable = false)
    private String publishDate;

    @Column(nullable = false)
    private int pages;

    @Column(nullable = false)
    private boolean availability;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private String rackNo;


    @JoinColumn  // adds the PK of Card table as a FK to the Book Table
    @ManyToOne
    private Card card;


    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionList;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getRackNo() {
        return rackNo;
    }

    public void setRackNo(String rackNo) {
        this.rackNo = rackNo;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
