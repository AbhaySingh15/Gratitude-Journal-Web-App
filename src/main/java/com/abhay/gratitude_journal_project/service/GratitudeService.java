package com.abhay.gratitude_journal_project.service;

import com.abhay.gratitude_journal_project.model.GratitudeData;
import com.abhay.gratitude_journal_project.model.GratitudeDate;
import com.abhay.gratitude_journal_project.model.GratitudeEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface GratitudeService {
     List<GratitudeDate> getListOfGratitudeDate();
     Map<Date, List<String>> getListOfGratitudeData();
}
