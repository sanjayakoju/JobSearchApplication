package com.ea.cs544.jobsearchapplication.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private double salary;
    @Version
    private long version;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private List<Skill> skills;
    @OneToOne(cascade = CascadeType.ALL)
    private Company company;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private List<Interview> interviews;

    public Job() {
    }

    public Job(String title, double salary, List<Skill> skills, Company company, List<Interview> interviews) {
        this.title = title;
        this.salary = salary;
        this.skills = skills;
        this.company = company;
        this.interviews = interviews;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<Interview> interviews) {
        this.interviews = interviews;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                ", company=" + company +
                ", interviews=" + interviews +
                '}';
    }
}
