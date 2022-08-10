package com.ea.cs544.jobsearchapplication.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int experience;
    private String language;
    private String description;
    @Version
    private long version;

    public Skill() {
    }

    public Skill(String name, int experience, String language, String description) {
        this.name = name;
        this.experience = experience;
        this.language = language;
        this.description = description;
    }

    public Skill(int id, String name, int experience, String language, String description) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.language = language;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experience='" + experience + '\'' +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
