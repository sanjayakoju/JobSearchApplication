package com.ea.cs544.jobsearchapplication.repository;

import com.ea.cs544.jobsearchapplication.model.Application;
import com.ea.cs544.jobsearchapplication.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    Application findApplicationByJob(Optional<Job> job);

    @Query(value = "DELETE FROM Application where job_id = ?1", nativeQuery = true)
    void deleteByJobId(int id);
}
