package com.abhay.gratitude_journal_project.service;
import com.abhay.gratitude_journal_project.model.GratitudeDate;
import com.abhay.gratitude_journal_project.repository.GratitudeDataRepository;
import com.abhay.gratitude_journal_project.repository.GratitudeDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public Map<Date, List<String>> getListOfGratitudeData() {
        // getting list of ids from DateDB
       List<Integer> listOfDateIds = gratitudeDateRepository.getListOfDateIds();
       // Creating map to store date and list of gratitude associated with that date
       Map<Date, List<String>> gratitudeGroupedByDate = new TreeMap<>();
       // iterating over list of ids to find date associated with each id and then storing date and list of gratitude
        // for that date in a map.
       for(Integer id: listOfDateIds){
            List<String> gratitudeListById = gratitudeDataRepository.getGratitudeListById(id);
            Date gratitudeDateById = gratitudeDateRepository.getGratitudeDateById(id);
            gratitudeGroupedByDate.put(gratitudeDateById,gratitudeListById);
       }
       // returning the map with date as key and list of gratitude for that date
       return gratitudeGroupedByDate;
    }
}
