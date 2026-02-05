package com.acciojob.student_library_management_system.repository;

import com.acciojob.student_library_management_system.entities.Book;
import com.acciojob.student_library_management_system.enums.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository                                     //Entity,datatype of Primary Key
public interface IBookRepository extends JpaRepository<Book, UUID> {

    Optional<Book> findByBookName(String bookName);

    List<Book> findByAvailability(Availability availability);
}

