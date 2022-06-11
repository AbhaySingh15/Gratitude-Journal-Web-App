package com.abhay.gratitude_journal_project.repository;

import com.abhay.gratitude_journal_project.model.GratitudeData;
import com.abhay.gratitude_journal_project.model.GratitudeDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GratitudeDateRepository extends JpaRepository<GratitudeDate,Integer> {

}
