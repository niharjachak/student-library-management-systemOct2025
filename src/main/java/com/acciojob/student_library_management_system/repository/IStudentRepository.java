package com.acciojob.student_library_management_system.repository;

import com.acciojob.student_library_management_system.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository                                               //Entity,datatype of Primary Key
public interface IStudentRepository extends JpaRepository<Student, UUID> {

    Optional<Student> findByEmail(String studEmail);
}
