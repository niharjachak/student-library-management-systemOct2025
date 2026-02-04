package com.acciojob.student_library_management_system.entities;

import com.acciojob.student_library_management_system.enums.CardStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID cardId;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)  //takes value converts it into string and stores in database
    private CardStatus cardStatus;

    @Column(nullable = false)
    private LocalDate expiryDate;

    @Column(nullable = false)
    @CreationTimestamp  // auto adds the date and time when a new card is Created
    private Date createdDate;

    @Column(nullable = false)
    @UpdateTimestamp // automatically adds the date and time when a Card is Updated
    private String updatedDate;

    // the reference to this class is already been managed in the Card class
    @JsonBackReference // it has printed the student data already no need to print again
    @JoinColumn( ) // joins the primary key of Student "studentId" as a foreign key in the Card table
    @OneToOne() // @OneToOne:- One Card is Assigned to One Student
    // only the studentId will be stored in the Card table not the whole Student object
    private Student student;
    // In the database the card table will store the studentId as it is the Owning SIde of OneToOne Mapping

    @OneToMany(mappedBy = "card")  // cascade operation not possible because if card is deleted then no need to delete books
    private List<Book> bookList;

    @OneToMany(mappedBy = "card")
    private List<Transaction> transactionList;

}
