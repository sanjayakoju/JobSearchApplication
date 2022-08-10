package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.core.BaseService;
import com.ea.cs544.jobsearchapplication.exception.ExceptionHandler;
import com.ea.cs544.jobsearchapplication.model.Skill;
import com.ea.cs544.jobsearchapplication.repository.SkillRepository;
import com.ea.cs544.jobsearchapplication.repository.SkillSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService implements BaseService<Skill, Integer> {

    @Autowired
    SkillRepository skillRepository;

    @Override
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Optional<Skill> findOne(Integer integer) {
        if (skillRepository.findById(integer).isPresent()) {
            return skillRepository.findById(integer);
        } else {
            ExceptionHandler.handleException("Skill not found for Id : " + integer);
        }
        return null;
    }

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        try {
            skillRepository.deleteById(integer);
        } catch (Exception e) {
            ExceptionHandler.handleException("Skill not found for Id : " + integer);
        }
    }

    public List<Skill> findAllByExperience(Integer experience) {
        return skillRepository.findAllByExperience(experience);
    }

    public List<Skill> findAllSkillMoreThanEqualExperience(int experience) {
        return skillRepository.findAll(SkillSpecification.hasExperienceMoreThanEqual(experience));
    }
}
