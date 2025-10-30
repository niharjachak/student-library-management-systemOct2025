package com.acciojob.student_library_management_system.entities;

import com.acciojob.student_library_management_system.enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

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
    @CreationTimestamp  // auto adds the date and time when a new card is created
    private Date createdDate;

    @Column(nullable = false)
    private String updatedDate;

    @JoinColumn
    @OneToOne
    private Student student;

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
}
