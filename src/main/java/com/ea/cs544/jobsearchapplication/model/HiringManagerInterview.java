package com.ea.cs544.jobsearchapplication.model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class HiringManagerInterview extends Interview {

    private int teamSize;
    private LocalDate startDate;

    public HiringManagerInterview() {
    }

    public HiringManagerInterview(int teamSize, LocalDate startDate) {
        this.teamSize = teamSize;
        this.startDate = startDate;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "HiringManagerInterview{" +
                "teamSize=" + teamSize +
                ", startDate=" + startDate +
                '}';
    }
}
