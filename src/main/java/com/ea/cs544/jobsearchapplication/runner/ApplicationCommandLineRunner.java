package com.ea.cs544.jobsearchapplication.runner;

import com.ea.cs544.jobsearchapplication.enums.InterviewResult;
import com.ea.cs544.jobsearchapplication.enums.Location;
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
        List<Skill> skillList2 = new ArrayList<>();
        skillList1.add(skill1);
        skillList2.add(skill1);
        skillList2.add(skill2);

        List<Client> clients = new ArrayList<>();
        List<Client> clients2 = new ArrayList<>();

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
        clients2.add(client2);

        Recruiter recruiter1 = new Recruiter();
        recruiter1.setName("K-Force");
        recruiter1.setAddress(new Address("2001A 3rd ES", "Mt Pleasant", "IOWA", "65564"));
        recruiter1.setClients(clients);

        Recruiter recruiter2 = new Recruiter();
        recruiter2.setName("JetBrains");
        recruiter2.setAddress(new Address("0001A St", "San Fransisco", "California", "123456"));
        recruiter2.setClients(clients2);

        ScreeningInterview screeningInterview1 = new ScreeningInterview();
        screeningInterview1.setName("Sanjaya");
        screeningInterview1.setDate(new Date(2022, 03,23));
        screeningInterview1.setResult(InterviewResult.PASS);
        screeningInterview1.setEmail("sanjayakoju42@gmail.com");
        screeningInterview1.setPhoneNumber("6418192555");

        ScreeningInterview screeningInterview2 = new ScreeningInterview();
        screeningInterview2.setName("Dina");
        screeningInterview2.setDate(new Date(2012, 03,23));
        screeningInterview2.setResult(InterviewResult.FAIL);
        screeningInterview2.setEmail("ukg@gmail.com");
        screeningInterview2.setPhoneNumber("346346");

        HiringManagerInterview hiringManagerInterview1 = new HiringManagerInterview();
        hiringManagerInterview1.setDate(new Date());
        hiringManagerInterview1.setEmail("heelo@gmail.com");
        hiringManagerInterview1.setPhoneNumber("34634634636");
        hiringManagerInterview1.setStartDate(new Date());
        hiringManagerInterview1.setTeamSize(12);

        HiringManagerInterview hiringManagerInterview2 = new HiringManagerInterview();
        hiringManagerInterview2.setDate(new Date());
        hiringManagerInterview2.setEmail("sujan@gmail.com");
        hiringManagerInterview2.setPhoneNumber("212519975");
        hiringManagerInterview2.setStartDate(new Date());
        hiringManagerInterview2.setTeamSize(5);

        TechnicalInterview technicalInterview1 = new TechnicalInterview();
        technicalInterview1.setDate(new Date());
        technicalInterview1.setEmail("tech@gmai.com");
        technicalInterview1.setLocation(Location.ONLINE);
        technicalInterview1.setPhoneNumber("1243263463");
        technicalInterview1.setDuration("4");
        technicalInterview1.setQuestions("how much expericen do you have?");

        List<Interview> interviewList1 = new ArrayList<>();
        interviewList1.add(screeningInterview1);
        interviewList1.add(hiringManagerInterview1);


        List<Interview> interviewList2 = new ArrayList<>();
        interviewList2.add(screeningInterview2);
        interviewList2.add(hiringManagerInterview2);
        interviewList2.add(technicalInterview1);


        Job job1 = new Job();
        job1.setTitle("Software Developer");
        job1.setCompany(recruiter1);
        job1.setSalary(60000);
        job1.setSkills(skillList1);
        job1.setInterviews(interviewList1);

        Job job2 = new Job();
        job2.setTitle("Software Developer II");
        job2.setCompany(recruiter1);
        job2.setSalary(160000);
        job2.setSkills(skillList1);
        job2.setInterviews(interviewList2);

        Job job3 = new Job();
        job3.setTitle("Senior Software Developer I");
        job3.setCompany(recruiter2);
        job3.setSalary(436436);
        job3.setSkills(skillList2);
        job3.setInterviews(interviewList2);

        Application application1 = new Application();
        application1.setDate(new Date());
        application1.setJob(job1);
        application1.setResumeVersion(1.0);

        Application application2 = new Application();
        application2.setDate(new Date());
        application2.setJob(job2);
        application2.setResumeVersion(2.0);

        Application application3 = new Application();
        application3.setDate(new Date());
        application3.setJob(job3);
        application3.setResumeVersion(2.0);

        applicationRepository.save(application1);
        applicationRepository.save(application2);
        applicationRepository.save(application3);

    }
}
