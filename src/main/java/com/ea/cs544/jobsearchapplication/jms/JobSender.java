package com.ea.cs544.jobsearchapplication.jms;

import com.ea.cs544.jobsearchapplication.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class JobSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value(value = "${spring.jms.cs544Queue}")
    private String queueName;

//    public void send(Job job) {
//        MessageCreator messageCreator = new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                return session.createObjectMessage(job);
//            }
//        };
//        jmsTemplate.send(queueName, messageCreator);
//    }

    public void send(String message) {
        jmsTemplate.convertAndSend(queueName, message);
    }

}
