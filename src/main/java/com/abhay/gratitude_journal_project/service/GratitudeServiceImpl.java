package com.abhay.gratitude_journal_project.service;

import com.abhay.gratitude_journal_project.model.GratitudeDate;
import com.abhay.gratitude_journal_project.repository.GratitudeDataRepository;
import com.abhay.gratitude_journal_project.repository.GratitudeDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GratitudeServiceImpl implements GratitudeService {
    @Autowired
    GratitudeDateRepository gratitudeDateRepository;

    @Autowired
    GratitudeDataRepository gratitudeDataRepository;

    @Override
    public List<GratitudeDate> getListOfGratitudeDate() {
        return gratitudeDateRepository.findAll();
    }
}
