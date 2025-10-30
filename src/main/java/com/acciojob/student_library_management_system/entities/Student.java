package com.acciojob.student_library_management_system.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    // Student -> id, name, email, mobile, dept, sem, gender, address, dob…
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

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
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
