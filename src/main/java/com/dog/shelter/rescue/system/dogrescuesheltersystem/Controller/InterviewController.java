package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.InterviewService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.InterviewForm;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Result;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.ReviewingForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    InterviewService interviewService;

    @GetMapping
    public Result getInterview(Long id, Long application_id, Long staff_id){
        log.info("Querying interview form with id: {} and application id: {}, staff_id: {}", id, application_id, staff_id);

        return Result.success(interviewService.getInterview(id, application_id, staff_id));
    }

    @PostMapping("/save")
    public Result saveInterview(@RequestBody InterviewForm interviewForm){
        log.info("Adding reviewing form: {}", interviewForm.toString());
        interviewService.save(interviewForm);
        return Result.success();
    }

    @PutMapping("/edit")
    public Result editInterview(@RequestBody InterviewForm interviewForm){
        log.info("Editing reviewing form: {}", interviewForm.toString());
        interviewService.edit(interviewForm);
        return Result.success();
    }
}
