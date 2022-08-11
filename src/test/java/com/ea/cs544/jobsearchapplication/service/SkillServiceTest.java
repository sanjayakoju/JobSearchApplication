package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.model.Skill;
import com.ea.cs544.jobsearchapplication.repository.SkillRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class SkillServiceTest {

    private Skill skill;

    @TestConfiguration
    static class SkillServiceImpTestContextConfiguration {
        @Bean
        public SkillService skillService() {
            return new SkillService();
        }
    }

    @Autowired
    SkillService skillService;

    @MockBean
    private SkillRepository skillRepository;

    @Test
    public void saveSkill() {
        skill = new Skill(1,"Software Developer", 5, "JAVA", "FullStack Java Developer");
        skillService.save(skill);
        verify(skillRepository, times(1)).save(skill);
    }


    @Before
    public void setUpSkill() {
        int skillId = 1;
        skill = new Skill(1,"Software Developer", 5, "JAVA", "FullStack Java Developer");
        Optional<Skill> javaOptional = Optional.of(skill);
        Mockito.when(skillRepository.findById(skillId)).thenReturn(javaOptional);
    }

    @Test
    public void skillById() {
        int skillId = 1;
        Optional<Skill> skillFound = skillService.findOne(skillId);
        Skill skill = skillFound.get();
        assertThat(skill.getId()).isEqualTo(skillId);
    }

    @Test
    public void getAllSkill() {
        Skill skill = new Skill(1,"Software Developer", 3, "JAVA", "FullStack Java Developer");
        skillService.save(skill);
        given(skillRepository.findAll()).willReturn(Collections.emptyList());
        // when -  action or the behaviour that we are going test
        List<Skill> skillList = skillService.findAll();
        // then - verify the output
        assertThat(skillList).isEmpty();
        assertThat(skillList.size()).isEqualTo(0);
    }

    @Test
    public void deleteSkill() {
        int id = 1;
        willDoNothing().given(skillRepository).deleteById(id);
        skillService.deleteById(id);
        verify(skillRepository, times(1)).deleteById(id);
    }

    @Test
    public void updateSkill() {
        Skill skill = new Skill(1,"Software Developer", 3, "JAVA", "FullStack Java Developer");
        given(skillRepository.save(skill)).willReturn(skill);
        skill.setLanguage("JavaScript");
        skill.setExperience(6);
        Skill updatedSkill = skillService.save(skill);
        assertThat(updatedSkill.getExperience()).isEqualTo(6);
        assertThat(updatedSkill.getLanguage()).isEqualTo("JavaScript");
    }
}
