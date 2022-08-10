package com.ea.cs544.jobsearchapplication.controller;

import com.ea.cs544.jobsearchapplication.model.Skill;
import com.ea.cs544.jobsearchapplication.service.SkillService;
import com.ea.cs544.jobsearchapplication.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/skill")
public class SkillController {

    @Autowired
    SkillService skillService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Skill skill) {
        return new RestResponse().successModel(skillService.save(skill));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new RestResponse().successModel(skillService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return new RestResponse().successModel(skillService.findOne(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Skill skill) {
        return new RestResponse().successModel(skillService.save(skill));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<Skill> skill = skillService.findOne(id);
        skillService.deleteById(id);
        return new RestResponse().successModel(skill);
    }
}
