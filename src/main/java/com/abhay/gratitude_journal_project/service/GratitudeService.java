package com.abhay.gratitude_journal_project.service;

import com.abhay.gratitude_journal_project.model.GratitudeDate;
import com.abhay.gratitude_journal_project.model.GratitudeEntity;

import java.util.List;

public interface GratitudeService {
    public List<GratitudeDate> getListOfGratitudeDate();
}
