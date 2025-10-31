package com.acciojob.student_library_management_system.repository;

import com.acciojob.student_library_management_system.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
}
