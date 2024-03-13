package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Beans.ReviewingFormBean;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.ReviewingForm;

import java.util.List;

public interface ReviewingPageService {
    List<ReviewingForm> getReviewing(Long id, Long application_id);

    void save(ReviewingForm reviewingForm);

    void edit(ReviewingForm reviewingForm);
}
