package com.ea.cs544.jobsearchapplication.repository;

import com.ea.cs544.jobsearchapplication.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>, JpaSpecificationExecutor<Job> {

    @Query(value = "select * from job where id = ?1",nativeQuery = true)
    Job findByJobId(int id);

    @Query(value = "SELECT j FROM Job j WHERE size(j.interviews) = ?1" )
    List<Job> findAllJobWithInterview(int numberOfInterview);

    @Query(value = "SELECT * FROM job WHERE company_id = ?1", nativeQuery = true)
    List<Job> findAllByCompanyId(Integer id);
}
