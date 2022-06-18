package com.abhay.gratitude_journal_project.repository;

import com.abhay.gratitude_journal_project.model.Gratitude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GratitudeRepository extends JpaRepository<Gratitude,Integer> {

    // https://spring.io/blog/2014/07/15/spel-support-in-spring-data-jpa-query-definitions
    @Query(value = "select gratitudeText from Gratitude where gratitudeDate.id = :#{#id}")
    List<String> getGratitudeListById(@Param("id") int id);
}