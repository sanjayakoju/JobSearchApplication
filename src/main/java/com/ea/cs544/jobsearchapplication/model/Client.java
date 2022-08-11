package com.ea.cs544.jobsearchapplication.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("client")
public class Client extends Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mission;
    private String reason;
    private String website;
    @Version
    private long version;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;

    public Client() {
    }

    public Client(String mission, String reason, String website) {
        this.mission = mission;
        this.reason = reason;
        this.website = website;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", mission='" + mission + '\'' +
                ", reason='" + reason + '\'' +
                ", website='" + website + '\'' +
                ", version=" + version +
                ", recruiter=" + recruiter +
                '}';
    }
}
