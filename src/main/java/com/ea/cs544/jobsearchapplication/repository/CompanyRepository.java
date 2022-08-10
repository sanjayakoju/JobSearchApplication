package com.ea.cs544.jobsearchapplication.repository;

import com.ea.cs544.jobsearchapplication.model.Company;
import com.ea.cs544.jobsearchapplication.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>, JpaSpecificationExecutor<Company> {

    @Query("SELECT c FROM Company c WHERE c.address.state = ?1")
    List<Company> findCompanyByState(String state);

    @Query("SELECT c FROM Company c where c.address.city =?1")
    List<Company> findCompanyByCity(String state);

    @Query(value = "SELECT c.* FROM Job j JOIN Company c ON j.salary > ?1 AND c.company_type = 'recruiter'", nativeQuery = true)
    List<Recruiter> findRecruiterBySalary(double salary);
}
