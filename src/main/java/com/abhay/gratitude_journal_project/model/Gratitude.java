package com.abhay.gratitude_journal_project.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Gratitudes")
public class Gratitude {

    @Column(name = "gratitude_text")
    @NotNull
    @NotBlank
    private String gratitudeText;

    @Id
    @Column(name = "gratitude_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gratitude_id;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "gratitude_date_id",referencedColumnName = "id")
    private GratitudeDate gratitudeDate;

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
    public int getGratitude_id() {
        return gratitude_id;
    }

    public void setGratitude_id(int gratitude_id) {
        this.gratitude_id = gratitude_id;
    }

}
