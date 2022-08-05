package com.ea.cs544.jobsearchapplication.model;

import com.ea.cs544.jobsearchapplication.enums.InterviewResult;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class ScreeningInterview extends Interview {

    private String name;
    @Enumerated(EnumType.STRING)
    private InterviewResult result;

    public ScreeningInterview() {

    }

    public ScreeningInterview(LocalDate date, String phoneNumber, String email, String name, InterviewResult result) {
        super(date, phoneNumber, email);
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InterviewResult getResult() {
        return result;
    }

    public void setResult(InterviewResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ScreeningInterview{" +
                "name='" + name + '\'' +
                ", result=" + result +
                '}';
    }
}
