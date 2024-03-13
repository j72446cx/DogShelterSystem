package com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.InterviewForm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterviewRepository {
    List<InterviewForm> getInterview(Long id, Long application_id, Long staff_id);

    @Insert("INSERT INTO InterviewForm (application_id, staff_id, body_language, intimate_contact, eye_contact, play, response_instruction, summary) VALUES (#{application_id}, #{staff_id}, #{body_language}, #{intimate_contact}, #{eye_contact}, #{play}, #{response_instruction}, #{summary})")
    void save(InterviewForm interviewForm);

    void edit(InterviewForm interviewForm);
}
