package com.ea.cs544.jobsearchapplication.controller;

import com.ea.cs544.jobsearchapplication.model.Company;
import com.ea.cs544.jobsearchapplication.service.CompanyService;
import com.ea.cs544.jobsearchapplication.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Company company) {
        return new RestResponse().successModel(companyService.save(company));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return new RestResponse().successModel(companyService.findOne(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Company company) {
        return new RestResponse().successModel(companyService.save(company));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new RestResponse().successModel(companyService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        Optional<Company> company = companyService.findOne(id);
        companyService.deleteById(id);
        return new RestResponse().successModel(company);
    }

    @GetMapping("/state")
    public ResponseEntity<?> findAllCompanyByState(@RequestParam String state) {
        return new RestResponse().successModel(companyService.findAllByState(state));
    }

    @GetMapping("/city")
    public ResponseEntity<?> findAllCompanyByCity(@RequestParam String city) {
        return new RestResponse().successModel(companyService.findAllByCity(city));
    }

    @GetMapping("/recruiter")
    public ResponseEntity<?> findAllRecruiterBySalaryGreaterThan(@RequestParam double salary) {
        return new RestResponse().successModel(companyService.findRecruiterBySalary(salary));
    }
}
