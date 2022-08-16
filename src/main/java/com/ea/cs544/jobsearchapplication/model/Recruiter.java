package com.ea.cs544.jobsearchapplication.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("recruiter")
public class Recruiter extends Company implements Serializable {


    @Version
    private long version;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Client> clients;

    public Recruiter() {
    }

    public Recruiter(String name, Address address, List<Client> clients) {
        super(name, address);
        this.clients = clients;
    }


    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Recruiter{" +
                ", clients=" + clients +
                ", address=" + address +
                '}';
    }
}
