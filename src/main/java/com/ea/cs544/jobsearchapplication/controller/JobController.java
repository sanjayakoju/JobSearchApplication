package com.ea.cs544.jobsearchapplication.controller;

import com.ea.cs544.jobsearchapplication.jms.JobSender;
import com.ea.cs544.jobsearchapplication.model.Job;
import com.ea.cs544.jobsearchapplication.service.JobService;
import com.ea.cs544.jobsearchapplication.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/job")
public class JobController {

    @Autowired
    JobService jobService;
    @Autowired
    JobSender jobSender;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Job job) {
        jobSender.send(job);
        return new RestResponse().successModel(jobService.save(job));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new RestResponse().successModel(jobService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return new RestResponse().successModel(jobService.findOne(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Job job) {
        return new RestResponse().successModel(jobService.save(job));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        Optional<Job> job = jobService.findOne(id);
        jobService.deleteById(id);
        return new RestResponse().successModel(job);
    }
}
