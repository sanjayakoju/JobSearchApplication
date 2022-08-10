package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.core.BaseService;
import com.ea.cs544.jobsearchapplication.exception.ResourceNotFoundException;
import com.ea.cs544.jobsearchapplication.model.Company;
import com.ea.cs544.jobsearchapplication.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements BaseService<Company, Integer> {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company save(Company company) {
        if (company != null) {
            return companyRepository.save(company);
        } else {
            throw new ResourceNotFoundException("Company Data Error");
        }
    }

    @Override
    public Optional<Company> findOne(Integer integer) {
        return companyRepository.findById(integer);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void delete(Company entity) {
        companyRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer integer) {
        companyRepository.deleteById(integer);
    }
}
