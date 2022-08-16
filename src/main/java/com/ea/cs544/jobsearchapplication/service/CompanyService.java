package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.core.BaseService;
import com.ea.cs544.jobsearchapplication.exception.ExceptionHandler;
import com.ea.cs544.jobsearchapplication.model.Company;
import com.ea.cs544.jobsearchapplication.model.Job;
import com.ea.cs544.jobsearchapplication.model.Recruiter;
import com.ea.cs544.jobsearchapplication.repository.CompanyRepository;
import com.ea.cs544.jobsearchapplication.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements BaseService<Company, Integer> {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    JobRepository jobRepository;
    @Autowired
    JobService jobService;


    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Optional<Company> findOne(Integer integer) {
        if (companyRepository.findById(integer).isPresent()) {
            return companyRepository.findById(integer);
        } else {
            ExceptionHandler.handleException("Company not found for Id : " + integer);
        }
        return null;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
       try {
           List<Job> jobList =  jobRepository.findAllByCompanyId(integer);
           if (jobList!= null) {
               for (Job job: jobList) {
                   jobService.deleteById(job.getId());
               }
           }
           companyRepository.deleteById(integer);
       } catch (Exception ex) {
           System.out.println(ex);
           ExceptionHandler.handleException("Company not found for Id : " +integer);
       }
    }

    public List<Company> findAllByState(String state) {
        try {
            return companyRepository.findCompanyByState(state);
        } catch (Exception e) {
            ExceptionHandler.handleException("Company not found for state : " + state);
        }
        return null;
    }

    public List<Company> findAllByCity(String city) {
        try {
            return companyRepository.findCompanyByCity(city);
        } catch (Exception e) {
            ExceptionHandler.handleException("Company not found for city : " + city);
        }
        return null;
    }

    public List<Recruiter> findRecruiterBySalary(double salary) {
        try {
            return companyRepository.findRecruiterBySalary(salary);
        } catch (Exception e) {
            ExceptionHandler.handleException("Recruiter not found who pay salary more than : " + salary);
        }
        return null;
    }
}
