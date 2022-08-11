package com.ea.cs544.jobsearchapplication.service;

import com.ea.cs544.jobsearchapplication.model.Interview;
import com.ea.cs544.jobsearchapplication.repository.InterviewRepository;
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
public class InterviewServiceTest {

    @InjectMocks
    private InterviewService interviewService;

    @Mock
    private InterviewRepository interviewRepository;

    private Interview newInterview;

    @BeforeEach
    public void beforeEach() {
        newInterview = createNewInterview();
    }

    private Interview createNewInterview() {
        Interview technicalInterview = new Interview();
        technicalInterview.setId(1);
        technicalInterview.setDate(new Date());
        technicalInterview.setEmail("sanjaya.koju@miu.edu");
        technicalInterview.setPhoneNumber("6418192555");
        return technicalInterview;
    }

    @Test
    public void testSaveNewInterview() {
        when(interviewRepository.save(newInterview)).thenReturn(newInterview);
        Assertions.assertEquals(interviewService.save(newInterview), newInterview);
    }

    @Test
    public void testGetAllInterviews() {
        List<Interview> repositoryInterviewList = List.of(createNewInterview());
        when(interviewRepository.findAll()).thenReturn(repositoryInterviewList);
        Assertions.assertEquals(interviewService.findAll(), repositoryInterviewList);
    }

    @Test
    public void testGetByInterviewID() {
        Optional<Interview> interview = Optional.ofNullable(newInterview);
        when(interviewRepository.findById(newInterview.getId())).thenReturn(Optional.ofNullable(newInterview));
        Assertions.assertEquals(interviewService.findOne(newInterview.getId()), interview);
    }

    @Test
    public void testDeleteInterview() {
        int id = 1;
        willDoNothing().given(interviewRepository).deleteById(id);
        interviewRepository.deleteById(id);
        verify(interviewRepository, times(1)).deleteById(id);
    }

}
