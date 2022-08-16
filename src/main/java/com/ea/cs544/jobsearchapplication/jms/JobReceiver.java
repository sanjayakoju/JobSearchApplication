package com.ea.cs544.jobsearchapplication.jms;

import com.ea.cs544.jobsearchapplication.model.Job;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JobReceiver {

//    @JmsListener(destination = "${spring.jms.cs544Queue}")
//    public void receive(Job job) {
//        System.out.println("Receiver Job > "+job);
//    }

    @JmsListener(destination = "${spring.jms.cs544Queue}")
    public void receive(String message) {
        System.out.println("Receiver : "+message);
    }
}
