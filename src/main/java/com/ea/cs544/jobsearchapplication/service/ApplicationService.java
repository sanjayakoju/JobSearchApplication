package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.core.BaseService;
import com.ea.cs544.jobsearchapplication.enums.InterviewResult;
import com.ea.cs544.jobsearchapplication.exception.ExceptionHandler;
import com.ea.cs544.jobsearchapplication.model.Application;
import com.ea.cs544.jobsearchapplication.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService implements BaseService<Application, Integer> {

    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Optional<Application> findOne(Integer integer) {
        if (applicationRepository.findById(integer).isPresent()) {
            return applicationRepository.findById(integer);
        } else {
            ExceptionHandler.handleException("Application not found for Id:" +integer);
        }
        return null;
    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        try {
            applicationRepository.deleteById(integer);
        } catch (Exception ex) {
            System.out.println(ex);
            ExceptionHandler.handleException("Application not found for Id: "+integer);
        }
    }

    public List<Application> findAllInterviewPassApplication(InterviewResult interviewResult) {
        return applicationRepository.findAllInterviewPassApplication(String.valueOf(interviewResult));
    }
}
