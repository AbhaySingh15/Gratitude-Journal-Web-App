package com.abhay.gratitude_journal_project.repository;

import com.abhay.gratitude_journal_project.model.GratitudeData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GratitudeDataRepository extends JpaRepository<GratitudeData,Integer> {
}
