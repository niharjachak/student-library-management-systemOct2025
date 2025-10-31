package com.acciojob.student_library_management_system.service;

import com.acciojob.student_library_management_system.repository.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    ICardRepository cardRepository;
}
