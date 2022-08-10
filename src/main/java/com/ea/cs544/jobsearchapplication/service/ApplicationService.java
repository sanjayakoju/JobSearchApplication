package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.core.BaseService;
import com.ea.cs544.jobsearchapplication.model.Application;
import com.ea.cs544.jobsearchapplication.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return applicationRepository.findById(integer);
    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    @Override
    public void delete(Application entity) {
        applicationRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer integer) {
        applicationRepository.deleteById(integer);
    }
}
