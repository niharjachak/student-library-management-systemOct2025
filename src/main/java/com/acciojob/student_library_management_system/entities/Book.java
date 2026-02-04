package com.acciojob.student_library_management_system.entities;

import com.acciojob.student_library_management_system.enums.Availability;
import com.acciojob.student_library_management_system.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="bookId")
    private UUID bookId;

    @Column(nullable = false, unique = true)
    private String bookName;

    @Column(nullable = false)
    private String bookPublisher;

    @Column(nullable = false)
    private String publishDate;

    @Column(nullable = false)
    private int pages;

    @Column(nullable = false)
    @Enumerated(value= EnumType.STRING)
    private Availability availability;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private String rackNo;


    @JoinColumn  // adds the PK of Card table as a FK to the Book Table
    @ManyToOne  // tells us which card is this book borrowed by
    private Card card;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionList;

}
