package com.ea.cs544.jobsearchapplication.model;

import com.ea.cs544.jobsearchapplication.enums.Location;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class TechnicalInterview extends Interview {

    private String duration;
    @Enumerated(EnumType.STRING)
    private Location location;
    private String questions;

    public TechnicalInterview() {

    }

    public TechnicalInterview(LocalDate date, String phoneNumber, String email, String duration, Location location, String questions) {
        super(date, phoneNumber, email);
        this.duration = duration;
        this.location = location;
        this.questions = questions;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "TechnicalInterview{" +
                "duration='" + duration + '\'' +
                ", location=" + location +
                ", questions='" + questions + '\'' +
                '}';
    }
}
