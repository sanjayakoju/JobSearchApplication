package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.core.BaseService;
import com.ea.cs544.jobsearchapplication.model.Job;
import com.ea.cs544.jobsearchapplication.repository.ApplicationRepository;
import com.ea.cs544.jobsearchapplication.repository.InterviewRepository;
import com.ea.cs544.jobsearchapplication.repository.JobRepository;
import com.ea.cs544.jobsearchapplication.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService implements BaseService<Job, Integer> {

    @Autowired
    JobRepository jobRepository;
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    InterviewRepository interviewRepository;
    @Autowired
    SkillRepository skillRepository;

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Optional<Job> findOne(Integer integer) {
        return jobRepository.findById(integer);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void delete(Job entity) {
        jobRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer integer) {
        jobRepository.deleteById(integer);
//        try {
//            jobRepository.deleteById(integer);
//        } catch (DataAccessException ex) {
//            ExceptionHandler.handleException("Job not found for ID: " + integer);
//        }
    }
}
