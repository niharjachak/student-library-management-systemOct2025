package com.acciojob.student_library_management_system.entities;

import com.acciojob.student_library_management_system.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    //-> id, transactionDate, dueDate, transactionType(BORROW or RETURN).
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID transactionId;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDate transactionDate;

    @Column(nullable = true)
    private LocalDate dueDate;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    @JoinColumn   // adds the PK bookId of Book as a FK to the Transaction table
    @ManyToOne
    private Book book;

    @JoinColumn   // adds the PK cardId of Card as a FK to the Transaction table
    @ManyToOne
    private Card card;

}
