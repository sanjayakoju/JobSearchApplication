package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.core.BaseService;
import com.ea.cs544.jobsearchapplication.model.Skill;
import com.ea.cs544.jobsearchapplication.repository.SkillRepository;
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
        return skillRepository.findById(integer);
    }

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public void delete(Skill entity) {
        skillRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer integer) {
        skillRepository.deleteById(integer);
    }
}
