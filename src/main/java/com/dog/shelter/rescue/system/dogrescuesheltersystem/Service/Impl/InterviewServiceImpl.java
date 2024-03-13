package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.Impl;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.InterviewRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.InterviewService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.InterviewForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    InterviewRepository interviewRepository;

    @Override
    public List<InterviewForm> getInterview(Long id, Long application_id, Long staff_id) {
        return interviewRepository.getInterview(id, application_id, staff_id);
    }

    @Override
    public void save(InterviewForm interviewForm) {
        interviewRepository.save(interviewForm);
    }

    @Override
    public void edit(InterviewForm interviewForm) {
        interviewRepository.edit(interviewForm);
    }
}
