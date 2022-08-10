package com.ea.cs544.jobsearchapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class JobSearchApplication {

    @Autowired
    private static Environment environment;

    public static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(JobSearchApplication.class, args);
//        System.out.println(JobSearchApplication.environment.getActiveProfiles());
    }


    public static void changeProfile(String env) {
        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(JobSearchApplication.class,"--spring.profiles.active="+ env);
        });

        thread.setDaemon(false);
        thread.start();
    }


}
