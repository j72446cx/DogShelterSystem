package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.Impl;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.ReviewingPageRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.ReviewingPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Beans.ReviewingFormBean;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.ReviewingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewingPageServiceImpl implements ReviewingPageService {

    @Autowired
    ReviewingPageRepository reviewingPageRepository;

    @Override
    public List<ReviewingForm> getReviewing(Long id, Long application_id) {

        return reviewingPageRepository.getReviewing(id, application_id);

    }

    @Override
    public void save(ReviewingForm reviewingForm) {
        reviewingPageRepository.save(reviewingForm);
    }

    @Override
    public void edit(ReviewingForm reviewingForm) {
        reviewingPageRepository.edit(reviewingForm);
    }
}
