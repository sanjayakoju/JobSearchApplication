package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.core.BaseService;
import com.ea.cs544.jobsearchapplication.model.Interview;
import com.ea.cs544.jobsearchapplication.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewService implements BaseService<Interview, Integer> {

    @Autowired
    InterviewRepository interviewRepository;

    @Override
    public Interview save(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public Optional<Interview> findOne(Integer integer) {
        return interviewRepository.findById(integer);
    }

    @Override
    public List<Interview> findAll() {
        return interviewRepository.findAll();
    }

    @Override
    public void delete(Interview entity) {
        interviewRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer integer) {
        interviewRepository.deleteById(integer);
    }
}
