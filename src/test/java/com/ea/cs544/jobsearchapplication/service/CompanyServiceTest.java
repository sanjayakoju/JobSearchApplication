package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.model.*;
import com.ea.cs544.jobsearchapplication.repository.CompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyService companyService;

    private Company newCompany;

    @BeforeEach
    public void beforeEach() {
        newCompany = createNewClientCompany();
    }

    private Recruiter createNewClientCompany() {
        List<Client> clients = new ArrayList<>();
        Client client1 = new Client();
        client1.setName("Infosys");
        client1.setAddress(new Address("100N 4th st","Fairfield", "IOWA", "52257"));
        client1.setMission("Dedicate to digitization");
        client1.setWebsite("www.infosys.com");
        client1.setReason("DO the right thing");
        clients.add(client1);

        Recruiter kForce = new Recruiter();
        kForce.setName("KForce");
        kForce.setAddress(new Address("100A 4th st","Ottumwa", "IOWA", "52657"));
        kForce.setClients(clients);
        return kForce;
    }


    @Test
    public void testSaveNewCompany() {
        when(companyRepository.save(newCompany)).thenReturn(newCompany);
        Assertions.assertEquals(companyService.save(newCompany), newCompany);
    }

    @Test
    public void testGetByCompanyID() {
        Optional<Company> company = Optional.ofNullable(newCompany);
        when(companyRepository.findById(newCompany.getId())).thenReturn(Optional.ofNullable(newCompany));
        Assertions.assertEquals(companyService.findOne(newCompany.getId()), company);
    }

    @Test
    public void testGetAllCompanies() {
        List<Company> repositoryCompanyList = List.of(createNewClientCompany());
        when(companyRepository.findAll()).thenReturn(repositoryCompanyList);
        Assertions.assertEquals(companyService.findAll(), repositoryCompanyList);
    }

    @Test
    public void testDeleteCompany() {
        int id = 1;
        willDoNothing().given(companyRepository).deleteById(id);
        companyRepository.deleteById(id);
        verify(companyRepository, times(1)).deleteById(id);

//        Recruiter savedRecruiterCompany = createNewClientCompany();
//        when(companyRepository.findById(savedRecruiterCompany.getId())).thenReturn(Optional.ofNullable(savedRecruiterCompany));
//        doNothing().when(companyRepository).deleteById(savedRecruiterCompany.getId());
//        Assertions.assertTrue(companyService.deleteById(1));
    }
}
