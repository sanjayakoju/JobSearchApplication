package com.ea.cs544.jobsearchapplication.repository;

import com.ea.cs544.jobsearchapplication.model.Skill;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SkillSpecification {

    public static Specification<Skill> hasExperienceMoreThanEqual(int experience) {
        return new Specification<Skill>() {
            @Override
            public Predicate toPredicate(Root<Skill> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicateExperience = criteriaBuilder.greaterThanOrEqualTo(root.get("experience"), experience);
                Predicate finalPredicate = criteriaBuilder.and(predicateExperience);
                return finalPredicate;
            }
        };
    }
}
