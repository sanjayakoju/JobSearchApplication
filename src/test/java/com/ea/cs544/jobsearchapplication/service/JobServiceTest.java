package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.model.Job;
import com.ea.cs544.jobsearchapplication.repository.JobRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class JobServiceTest {

    @Mock
    private JobRepository jobRepository;

    @InjectMocks
    private JobService jobService;

    private Job newJob;

    @BeforeEach
    public void beforeEach() {
        newJob = createJob();
    }

    public Job createJob() {
        Job job1 = new Job();
        job1.setId(1);
        job1.setTitle("Software Developer");
        job1.setSalary(60000);
        return job1;
    }

    @Test
    public void testSaveNewJob() {
        when(jobRepository.save(newJob)).thenReturn(newJob);
        Assertions.assertEquals(jobService.save(newJob), newJob);
    }

    @Test
    public void testGetAllJobs() {
        List<Job> repositoryJobList = List.of(createJob());
        when(jobRepository.findAll()).thenReturn(repositoryJobList);
        Assertions.assertEquals(jobService.findAll(), repositoryJobList);
    }

    @Test
    public void testGetByJobID() {
        Optional<Job> job = Optional.ofNullable(newJob);
        when(jobRepository.findById(newJob.getId())).thenReturn(Optional.ofNullable(newJob));
        Assertions.assertEquals(jobService.findOne(newJob.getId()), job);
    }

    @Test
    public void testDeleteCompany() {
        int id = 1;
        willDoNothing().given(jobRepository).deleteById(id);
        jobRepository.deleteById(id);
        verify(jobRepository, times(1)).deleteById(id);
    }
}
