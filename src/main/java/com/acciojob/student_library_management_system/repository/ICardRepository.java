package com.acciojob.student_library_management_system.repository;

import com.acciojob.student_library_management_system.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository                                 //Entity,datatype of Primary Key
public interface ICardRepository extends JpaRepository<Card,Integer> {

}
