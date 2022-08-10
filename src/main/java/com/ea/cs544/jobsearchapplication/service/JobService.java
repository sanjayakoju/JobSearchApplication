package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.core.BaseService;
import com.ea.cs544.jobsearchapplication.exception.ExceptionHandler;
import com.ea.cs544.jobsearchapplication.model.Application;
import com.ea.cs544.jobsearchapplication.model.Job;
import com.ea.cs544.jobsearchapplication.repository.*;
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
        if (jobRepository.findById(integer).isPresent()) {
            return jobRepository.findById(integer);
        } else {
            ExceptionHandler.handleException("Job not found for Id : " + integer);
        }
        return null;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        try {
            Job job = jobRepository.findByJobId(integer);
            Application application = applicationRepository.findApplicationByJob(job);
            applicationRepository.delete(application);
            jobRepository.deleteById(integer);
        } catch (Exception ex) {
            ExceptionHandler.handleException("Job not found for ID: " + integer);
        }
    }

    public List<Job> getJobWithSalaryGreaterThanWithinParticularState(double salary, String state) {
        return jobRepository.findAll(JobSpecification.hasSalaryGreaterThan(salary, state));
    }

    public List<Job> findAllByInterviews(int numberOfInterview) {
        return jobRepository.findAllJobWithInterview(numberOfInterview);
    }
}
