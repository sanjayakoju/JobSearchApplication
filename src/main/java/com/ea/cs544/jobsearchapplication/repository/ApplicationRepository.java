package com.ea.cs544.jobsearchapplication.repository;

import com.ea.cs544.jobsearchapplication.enums.InterviewResult;
import com.ea.cs544.jobsearchapplication.model.Application;
import com.ea.cs544.jobsearchapplication.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    Application findApplicationByJob(Job job);

    @Query(value = "select * from application as a\n" +
            "join job as j\n" +
            "on j.id = a.job_id\n" +
            "join interview as i\n" +
            "on i.job_id = j.id\n" +
            "join screeninginterview as si\n" +
            "on i.id = si.id\n" +
            "where si.result = ?1", nativeQuery = true)
    List<Application> findAllInterviewPassApplication(String interviewResult);

}
