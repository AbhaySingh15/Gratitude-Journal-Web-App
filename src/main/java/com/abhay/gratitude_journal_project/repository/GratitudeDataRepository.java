package com.abhay.gratitude_journal_project.repository;

import com.abhay.gratitude_journal_project.model.GratitudeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface GratitudeDataRepository extends JpaRepository<GratitudeData,Integer> {

    // https://spring.io/blog/2014/07/15/spel-support-in-spring-data-jpa-query-definitions
    @Query(value = "select gratitudeText from GratitudeData where id = :#{#id}")
    List<String> getGratitudeListById(@Param("id") int id);
}
