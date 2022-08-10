package com.ea.cs544.jobsearchapplication.controller;

import com.ea.cs544.jobsearchapplication.model.Interview;
import com.ea.cs544.jobsearchapplication.service.InterviewService;
import com.ea.cs544.jobsearchapplication.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/interview")
public class InterviewController {

    @Autowired
    InterviewService interviewService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Interview interview) {
        return new RestResponse().successModel(interviewService.save(interview));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new RestResponse().successModel(interviewService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return new RestResponse().successModel(interviewService.findOne(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Interview interview) {
        return new RestResponse().successModel(interviewService.save(interview));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        Optional<Interview> interview = interviewService.findOne(id);
        interviewService.deleteById(id);
        return new RestResponse().successModel(interview);
    }
}
