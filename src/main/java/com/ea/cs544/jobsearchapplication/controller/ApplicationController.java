package com.ea.cs544.jobsearchapplication.controller;

import com.ea.cs544.jobsearchapplication.enums.InterviewResult;
import com.ea.cs544.jobsearchapplication.model.Application;
import com.ea.cs544.jobsearchapplication.service.ApplicationService;
import com.ea.cs544.jobsearchapplication.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/application")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Application application) {
        return new RestResponse().successModel(applicationService.save(application));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new RestResponse().successModel(applicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return new RestResponse().successModel(applicationService.findOne(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Application application) {
        return new RestResponse().successModel(applicationService.save(application));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        Optional<Application> application = applicationService.findOne(id);
        applicationService.deleteById(id);
        return new RestResponse().successModel(application);
    }

    @GetMapping("/screeningInterview")
    public ResponseEntity<?> getAllScreeningInterviewResultTypeOfApplication(@RequestParam InterviewResult interviewResult) {
        return new RestResponse().successModel(applicationService.findAllInterviewPassApplication(interviewResult));
    }

}
