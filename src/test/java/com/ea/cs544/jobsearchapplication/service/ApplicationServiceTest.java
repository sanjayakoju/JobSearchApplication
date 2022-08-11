package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.model.Application;
import com.ea.cs544.jobsearchapplication.repository.ApplicationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @InjectMocks
    private ApplicationService applicationService;

    private Application newApplication;

    @BeforeEach
    public void beforeEach() {
        newApplication = createApplication();
    }

    private Application createApplication() {
        Application application = new Application();
        application.setId(1);
        application.setResumeVersion(1);
        application.setDate(new Date());
        return application;
    }

    @Test
    public void testSaveNewApplication() {
        when(applicationRepository.save(newApplication)).thenReturn(newApplication);
        Assertions.assertEquals(applicationService.save(newApplication), newApplication);
    }

    @Test
    public void testGetAllApplication() {
        List<Application> repositoryApplicationList = List.of(createApplication());
        when(applicationRepository.findAll()).thenReturn(repositoryApplicationList);
        Assertions.assertEquals(applicationService.findAll(), repositoryApplicationList);
    }

    @Test
    public void testGetByJobID() {
        Optional<Application> application = Optional.ofNullable(newApplication);
        when(applicationRepository.findById(newApplication.getId())).thenReturn(Optional.ofNullable(newApplication));
        Assertions.assertEquals(applicationService.findOne(newApplication.getId()), application);
    }

    @Test
    public void testDeleteCompany() {
        int id = 1;
        willDoNothing().given(applicationRepository).deleteById(id);
        applicationRepository.deleteById(id);
        verify(applicationRepository, times(1)).deleteById(id);
    }

}
