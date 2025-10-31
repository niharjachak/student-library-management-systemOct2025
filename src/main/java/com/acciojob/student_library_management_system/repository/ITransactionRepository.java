package com.acciojob.student_library_management_system.repository;

import com.acciojob.student_library_management_system.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction,Integer> {
}
