package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.core.BaseService;
import com.ea.cs544.jobsearchapplication.exception.ExceptionHandler;
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
        if (interviewRepository.findById(integer).isPresent()) {
            return interviewRepository.findById(integer);
        } else {
            ExceptionHandler.handleException("Interview not found for Id : "+integer);
        }
        return null;
    }

    @Override
    public List<Interview> findAll() {
        return interviewRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        try {
            interviewRepository.deleteById(integer);
        } catch (Exception exception) {
            ExceptionHandler.handleException("Interview not found for Id : " +integer);
        }
    }
}
