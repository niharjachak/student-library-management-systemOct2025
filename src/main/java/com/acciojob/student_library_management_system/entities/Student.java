package com.acciojob.student_library_management_system.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    // Student -> id, name, email, mobile, dept, sem, gender, address, dob…
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID studentId;
    @Column (nullable=false)
    private String studentName;
    @Column (nullable=false,unique = true)
    private String email;
    @Column (nullable=false,unique=true)
    private String mobile;
    @Column (nullable=false)
    private String dept;
    @Column (nullable=false)
    private String sem;
    @Column (nullable=false)
    private String gender;
    @Column (nullable=false)
    private String address;
    @Column (nullable=false)
    private String dob;

    // The field that owns the relationship.
    // This element is only specified on the inverse (non-owning) side of the association.
    // in the database the student will not store card_Id in student table as it is the Inverse side
    // of the OneToOne mapping
    @JsonManagedReference  //  mappedby= ManagedReference         // fetch type lazy means card will not be printed
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private Card card;


    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", dept='" + dept + '\'' +
                ", sem='" + sem + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
