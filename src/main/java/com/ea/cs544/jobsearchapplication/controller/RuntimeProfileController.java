package com.ea.cs544.jobsearchapplication.controller;

import com.ea.cs544.jobsearchapplication.JobSearchApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuntimeProfileController {

    @PutMapping("/restart/{environment}")
    public void profileChange(@PathVariable String environment) {
        JobSearchApplication.changeProfile(environment);
    }
}
