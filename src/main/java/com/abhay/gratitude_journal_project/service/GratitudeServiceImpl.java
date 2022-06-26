package com.abhay.gratitude_journal_project.service;
import com.abhay.gratitude_journal_project.model.Gratitude;
import com.abhay.gratitude_journal_project.model.GratitudeDate;
import com.abhay.gratitude_journal_project.repository.GratitudeRepository;
import com.abhay.gratitude_journal_project.repository.GratitudeDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GratitudeServiceImpl implements GratitudeService {
    @Autowired
    GratitudeDateRepository gratitudeDateRepository;

    @Autowired
    GratitudeRepository gratitudeRepository;

    @Override
    public List<GratitudeDate> getListOfGratitudeDate() {
        return gratitudeDateRepository.findAll();
    }

    @Override
    public Map<String, List<String>> getListOfGratitude() {
        // getting list of ids from DateDB
       List<Integer> listOfDateIds = gratitudeDateRepository.getListOfDateIds();
       // Creating map to store date and list of gratitude associated with that date
       Map<String, List<String>> gratitudeGroupedByDate = new TreeMap<>(Collections.reverseOrder());
       // iterating over list of ids to find date associated with each id and then storing date and list of gratitude
        // for that date in a map.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Integer id: listOfDateIds) {
            List<String> gratitudeListById = gratitudeRepository.getGratitudeListById(id);
            Date gratitudeDateById = gratitudeDateRepository.getGratitudeDateById(id);
            gratitudeGroupedByDate.put(sdf.format(gratitudeDateById), gratitudeListById);
        }
//        returning the map with formatted date as key and list of gratitude for that date
       return gratitudeGroupedByDate;
    }

    @Override
    public void insertGratitudeIntoDB(Gratitude gratitude) {

//       Date todayDate=new GregorianCalendar(2022, Calendar.JUNE,18).getTime();
        Date todayDate = new Date();

        try {
            // when there is no record in the database getReferenceId will throw exception as it couldn't
            // find the last inserted record.
            GratitudeDate lastInsertedGratitudeDateObject = gratitudeDateRepository.getReferenceById(gratitudeDateRepository.lastInsertedId());
            Date lastInsertedDate = lastInsertedGratitudeDateObject.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (sdf.format(todayDate).equals(sdf.format(lastInsertedDate))) {
                // If the latest date in dateDB and today's date is equal that means we just have to
                // add gratitude for this date.
                gratitude.setGratitudeDate(lastInsertedGratitudeDateObject);
                gratitudeRepository.save(gratitude);
            }else{
                createAndSetGratitudeDateForGratitude(todayDate,gratitude);
            }
            }
         catch (Exception e) {
            // When adding gratitude's for the first time
            System.out.println("No last inserted record found,creating and inserting new gratitudeDate object to DateDB");
            createAndSetGratitudeDateForGratitude(todayDate,gratitude);
        }
    }

        public void createAndSetGratitudeDateForGratitude(Date todayDate, Gratitude gratitude){
            // creating a gratitudeDate object for new date saving it to dateDB
            // and then adding gratitude for that date
            GratitudeDate newGratitudeDateObject = new GratitudeDate();
            newGratitudeDateObject.setDate(todayDate);
            gratitudeDateRepository.save(newGratitudeDateObject);
            gratitude.setGratitudeDate(newGratitudeDateObject);
            gratitudeRepository.save(gratitude);
        }
    }


