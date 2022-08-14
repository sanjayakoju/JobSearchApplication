package com.ea.cs544.jobsearchapplication.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;

@Entity
@DiscriminatorValue("HiringManagerInterview")
public class HiringManagerInterview extends Interview {

    private int teamSize;
    private Date startDate;

    public HiringManagerInterview() {
    }

    public HiringManagerInterview(int teamSize, Date startDate) {
        this.teamSize = teamSize;
        this.startDate = startDate;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
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
