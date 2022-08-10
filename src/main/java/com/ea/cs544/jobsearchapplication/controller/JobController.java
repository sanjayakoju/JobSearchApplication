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
        jobSender.send("Job Available List");
        return new RestResponse().successModel(jobService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        jobSender.send("Job Message send");
        return new RestResponse().successModel(jobService.findOne(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Job job) {
        jobSender.send("Job update for Id : "+job.getId());
        return new RestResponse().successModel(jobService.save(job));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        Optional<Job> job = jobService.findOne(id);
        jobService.deleteById(id);
        jobSender.send("Job delete Message Send for id : "+id);
        return new RestResponse().successModel(job);
    }

    @GetMapping("/jobs")
    public ResponseEntity<?> getJobByStateAndSalaryGreaterThan(@RequestParam String state, @RequestParam double salary) {
        return new RestResponse().successModel(jobService.getJobWithSalaryGreaterThanWithinParticularState(salary, state));
    }

    @GetMapping("/interview")
    public ResponseEntity<?> getJobByInterview(@RequestParam int numberOfInterview) {
        return new RestResponse().successModel(jobService.findAllByInterviews(numberOfInterview));
    }
}
