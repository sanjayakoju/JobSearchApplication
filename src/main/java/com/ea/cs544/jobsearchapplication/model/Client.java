package com.ea.cs544.jobsearchapplication.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("client")
public class Client extends Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mission;
    private String reason;
    private String website;
    @Version
    private long version;

    public Client() {
    }

    public Client(String mission, String reason, String website) {
        this.mission = mission;
        this.reason = reason;
        this.website = website;
    }

    public int getId() {
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", mission='" + mission + '\'' +
                ", reason='" + reason + '\'' +
                ", website='" + website + '\'' +
                ", address=" + address +
                '}';
    }
}
