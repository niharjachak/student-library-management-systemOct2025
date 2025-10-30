package com.acciojob.student_library_management_system.entities;

import com.acciojob.student_library_management_system.enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int cardId;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)  //takes value converts it into string and stores in database
    private CardStatus cardStatus;

    @Column(nullable = false)
    private String expiryDate;

    @Column(nullable = false)
    @CreationTimestamp  // auto adds the date and time when a new card is Created
    private Date createdDate;

    @Column(nullable = false)
    @UpdateTimestamp // automatically adds the date and time when a Card is Updated
    private String updatedDate;

    @JoinColumn() // joins the primary key of Student "studentId" as a foreign key in the Card table
    @OneToOne() // @OneToOne:- One Card is Assigned to One Student
    // only the studentId will be stored in the Card table not the whole Student object
    private Student student;

    @OneToMany(mappedBy = "card")  // cascade operation not possible because if card is deleted then no need to delete books
    private List<Book> bookList;

    @OneToMany(mappedBy = "card")
    private List<Transaction> transactionList;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
