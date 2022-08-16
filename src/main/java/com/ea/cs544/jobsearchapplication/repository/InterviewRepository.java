package com.ea.cs544.jobsearchapplication.repository;

import com.ea.cs544.jobsearchapplication.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer> {

    @Query(value = "Delete from Interview where job_id = ?1", nativeQuery = true)
    void deleteAllByJobId(Integer id);

    @Query(value = "SELECT * from interview where job_id = ?1", nativeQuery = true)
    List<Interview> findAllByJobId(int id);

}
