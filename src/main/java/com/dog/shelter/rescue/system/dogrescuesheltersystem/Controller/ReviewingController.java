package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;


import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.ReviewingPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Result;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.ReviewingForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/reviewing")
public class ReviewingController {

    @Autowired
    ReviewingPageService reviewingPageService;

    @GetMapping
    public Result getReviewing(Long id, Long application_id){
        log.info("Querying reviewing form with id: {} and application id: {}", id, application_id);

        return Result.success(reviewingPageService.getReviewing(id, application_id));
    }

    @PostMapping("/save")
    public Result saveReviewing(@RequestBody ReviewingForm reviewingForm){
        log.info("Adding reviewing form: {}", reviewingForm.toString());
        reviewingPageService.save(reviewingForm);
        return Result.success();
    }

    @PutMapping("/edit")
    public Result editReviewing(@RequestBody ReviewingForm reviewingForm){
        log.info("Editing reviewing form: {}", reviewingForm.toString());
        reviewingPageService.edit(reviewingForm);
        return Result.success();
    }


}
