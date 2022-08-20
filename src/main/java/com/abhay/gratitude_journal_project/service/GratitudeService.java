package com.abhay.gratitude_journal_project.service;

import com.abhay.gratitude_journal_project.model.Gratitude;
import com.abhay.gratitude_journal_project.model.GratitudeDate;

import java.util.List;
import java.util.Map;

public interface GratitudeService {
     List<GratitudeDate> getListOfGratitudeDate();
     Map<String, List<String>> getListOfGratitude();

     void insertGratitudeIntoDB(Gratitude gratitudeData);
}
