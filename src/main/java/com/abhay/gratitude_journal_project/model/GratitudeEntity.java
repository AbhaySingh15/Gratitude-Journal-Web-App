package com.abhay.gratitude_journal_project.model;

import org.thymeleaf.util.DateUtils;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="GratitudeDB")
public class GratitudeEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date gratitudeDate;

    @Column(name = "gratitude_text")
    private String gratitudeText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGratitudeDate() throws ParseException {
       return gratitudeDate;
    }

    public void setGratitudeDate(Date gratitudeDate) {
        this.gratitudeDate = gratitudeDate;
    }

    public String getGratitudeText() {
        return gratitudeText;
    }

    public void setGratitudeText(String gratitudeText) {
        this.gratitudeText = gratitudeText;
    }
}
