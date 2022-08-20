package com.abhay.gratitude_journal_project.service;

import com.abhay.gratitude_journal_project.model.Gratitude;
import com.abhay.gratitude_journal_project.model.GratitudeDate;
import com.abhay.gratitude_journal_project.repository.GratitudeDateRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GratitudeServiceImplTest {

    @Autowired
    private static GratitudeDateRepository gratitudeDateRepository;

    @Test
    void getListOfGratitudeDate() {
        assertNotNull(gratitudeDateRepository.findAll());
    }
}