package com.ea.cs544.jobsearchapplication.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    @Version
    private long version;
    private double resumeVersion;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Job job;

    public Application() {
    }

    public Application(Date date, double resumeVersion, Job job) {
        this.date = date;
        this.resumeVersion = resumeVersion;
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getResumeVersion() {
        return resumeVersion;
    }

    public void setResumeVersion(double resumeVersion) {
        this.resumeVersion = resumeVersion;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", date=" + date +
                ", version=" + version +
                ", resumeVersion=" + resumeVersion +
                ", job=" + job +
                '}';
    }
}
