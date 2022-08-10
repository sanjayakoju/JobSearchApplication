package com.ea.cs544.jobsearchapplication.repository;

import com.ea.cs544.jobsearchapplication.model.Application;
import com.ea.cs544.jobsearchapplication.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    Application findApplicationByJob(Job job);

}
