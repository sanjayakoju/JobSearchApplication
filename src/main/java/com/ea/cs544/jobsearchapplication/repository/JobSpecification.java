package com.ea.cs544.jobsearchapplication.repository;

import com.ea.cs544.jobsearchapplication.model.Job;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class JobSpecification {

    public static Specification<Job> hasSalaryGreaterThan(double salary, String state) {
        return new Specification<Job>() {
            @Override
            public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate salaryPredicate = criteriaBuilder.greaterThan(root.get("salary"), salary);
                Predicate companyStatePredicate = criteriaBuilder.equal(root.get("company").get("address").get("state"), state);
                Predicate finalPredicate = criteriaBuilder.and(salaryPredicate, companyStatePredicate);
                return finalPredicate;
            }
        };
    }
}
