package com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.ReviewingForm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewingPageRepository {

    List<ReviewingForm> getReviewing(Long id, Long application_id);

    @Insert("INSERT INTO ReviewingForm (application_id, customer_info_notes, form_info_notes, family_member_notes, residence_info_notes, personal_background_notes, dog_care_notes, overall_notes) VALUES (#{application_id}, #{customer_info_notes}, #{form_info_notes}, #{family_member_notes}, #{residence_info_notes}, #{personal_background_notes}, #{dog_care_notes}, #{overall_notes})")
    void save(ReviewingForm reviewingForm);


    void edit(ReviewingForm reviewingForm);
}
