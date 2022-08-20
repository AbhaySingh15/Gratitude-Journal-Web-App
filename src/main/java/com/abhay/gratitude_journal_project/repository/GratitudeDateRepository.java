package com.abhay.gratitude_journal_project.repository;
import com.abhay.gratitude_journal_project.model.GratitudeDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GratitudeDateRepository extends JpaRepository<GratitudeDate,Integer> {
    @Query(value = "select id from GratitudeDate order by date desc")
    List<Integer> getListOfDateIds();

    @Query(value = "Select date from GratitudeDate where id = :#{#id}")
    Date getGratitudeDateById(@Param("id") int id);

    @Query(value = "select max(id) as id from GratitudeDate")
    int lastInsertedId();

}
