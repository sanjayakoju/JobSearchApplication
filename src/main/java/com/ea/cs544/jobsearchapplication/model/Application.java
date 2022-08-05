package com.ea.cs544.jobsearchapplication.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    @Version
    private long version;
    private double resumeVersion;
    @OneToOne(cascade = CascadeType.ALL)
    private Job job;

    public Application() {
    }

    public Application(LocalDate date, double resumeVersion, Job job) {
        this.date = date;
        this.resumeVersion = resumeVersion;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getResumeVersion() {
        return resumeVersion;
    }

    public void setResumeVersion(double resumeVersion) {
        this.resumeVersion = resumeVersion;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", date=" + date +
                ", resumeVersion=" + resumeVersion +
                ", job=" + job +
                '}';
    }
}
