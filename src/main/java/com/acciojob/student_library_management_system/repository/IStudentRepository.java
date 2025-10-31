package com.acciojob.student_library_management_system.repository;

import com.acciojob.student_library_management_system.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer> {
}
