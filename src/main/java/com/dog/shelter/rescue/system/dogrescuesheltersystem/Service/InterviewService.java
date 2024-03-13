package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.InterviewForm;

import java.util.List;

public interface InterviewService {
    List<InterviewForm> getInterview(Long id, Long application_id, Long staff_id);

    void save(InterviewForm interviewForm);

    void edit(InterviewForm interviewForm);
}
