package com.abhay.gratitude_journal_project.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "Gratitudes")
public class GratitudeData {

    @Column(name = "gratitude_text")
    private String gratitudeText;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private GratitudeDate gratitudeDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    public String getGratitudeText() {
        return gratitudeText;
    }

    public void setGratitudeText(String gratitudeText) {
        this.gratitudeText = gratitudeText;
    }

    public GratitudeDate getGratitudeDate() {
        return gratitudeDate;
    }

    public void setGratitudeDate(GratitudeDate gratitudeDate) {
        this.gratitudeDate = gratitudeDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
