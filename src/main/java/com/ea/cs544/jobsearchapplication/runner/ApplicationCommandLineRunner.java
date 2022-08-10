package com.ea.cs544.jobsearchapplication.runner;

import com.ea.cs544.jobsearchapplication.enums.InterviewResult;
import com.ea.cs544.jobsearchapplication.model.*;
import com.ea.cs544.jobsearchapplication.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class ApplicationCommandLineRunner implements CommandLineRunner {

    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public void run(String... args) throws Exception {

        loadData();

    }

    private void loadData() {
        Skill skill1 = new Skill();
        skill1.setName("Frontend Developer");
        skill1.setExperience(2);
        skill1.setDescription("Design Single Page Application");
        skill1.setLanguage("Angular");

        Skill skill2 = new Skill();
        skill2.setName("Backend Developer");
        skill2.setExperience(3);
        skill2.setDescription("Good Knowledge of Backend development");
        skill2.setLanguage("Java");

        List<Skill> skillList1 = new ArrayList<>();
        skillList1.add(skill1);

        List<Client> clients = new ArrayList<>();

        Client client1 = new Client();
        client1.setName("Infosys");
        client1.setAddress(new Address("100N 4th st","Fairfield", "IOWA", "52257"));
        client1.setMission("Dedicate to digitization");
        client1.setWebsite("www.infosys.com");
        client1.setReason("DO the right thing");

        Client client2 = new Client();
        client2.setName("Wipro");
        client2.setAddress(new Address("100A 4th st","Ottumwa", "IOWA", "52657"));
        client2.setMission("Complete Health care solution");
        client2.setWebsite("www.Wipro.com");
        client2.setReason("Healthcare solution");

        clients.add(client1);
        clients.add(client2);

        Recruiter recruiter1 = new Recruiter();
        recruiter1.setName("K-Force");
        recruiter1.setAddress(new Address("2001A 3rd ES", "Mt Pleasant", "IOWA", "65564"));
        recruiter1.setClients(clients);

        ScreeningInterview screeningInterview1 = new ScreeningInterview();
        screeningInterview1.setName("Sanjaya");
        screeningInterview1.setDate(new Date(2022, 03,23));
        screeningInterview1.setResult(InterviewResult.PASS);
        screeningInterview1.setEmail("sanjayakoju42@gmail.com");
        screeningInterview1.setPhoneNumber("6418192555");

        List<Interview> interviewList1 = new ArrayList<>();
        interviewList1.add(screeningInterview1);


        Job job1 = new Job();
        job1.setTitle("Software Developer");
        job1.setCompany(recruiter1);
        job1.setSalary(60000);
        job1.setSkills(skillList1);
        job1.setInterviews(interviewList1);

        Application application1 = new Application();
        application1.setDate(new Date());
        application1.setJob(job1);
        application1.setResumeVersion(1.0);

        applicationRepository.save(application1);

    }
}
