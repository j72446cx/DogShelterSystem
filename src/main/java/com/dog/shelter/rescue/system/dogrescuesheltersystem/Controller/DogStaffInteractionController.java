package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.DogPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.*;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Request.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/interaction")
public class DogStaffInteractionController {

    @Autowired
    private DogPageService dogPageService;

    @GetMapping("/getFeed")
    public Result getFeed(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            Long dog_id, Long staff_id,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate feeding_time_start,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate feeding_time_end){
        log.info("Feed querying with parameter: with page: {}, pageSize: {}, dog_id: {}, staff_id:{}  feed_time between {} and {},"
                ,page, pageSize,dog_id, staff_id, feeding_time_start, feeding_time_end);

        return Result.success(dogPageService.getFeed(page, pageSize, dog_id, staff_id, feeding_time_start, feeding_time_end));
    }
    @GetMapping("/getGrooming")
    public Result getGrooming(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            Long dog_id, Long staff_id,
                              @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate grooming_time_start,
                              @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate grooming_time_end){
        log.info("Grooming querying with parameter: with page: {}, pageSize: {}, dog_id: {}, staff_id:{}  grooming_date between {} and {},"
                ,page, pageSize,dog_id, staff_id, grooming_time_start, grooming_time_end);

        return Result.success(dogPageService.getGrooming(page, pageSize, dog_id, staff_id, grooming_time_start, grooming_time_end));
    }

    @GetMapping("/getExercise")
    public Result getExercise(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer pageSize,
            Long dog_id, Long staff_id,
                              @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate exercise_time_start,
                              @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate exercise_time_end){
        log.info("Exercise querying with parameter: with page: {}, pageSize: {}, dog_id: {}, staff_id:{}  grooming_date between {} and {},"
                ,page, pageSize,dog_id, staff_id, exercise_time_start, exercise_time_end);

        return Result.success(dogPageService.getExercise(page, pageSize,dog_id, staff_id, exercise_time_start, exercise_time_end));
    }

    @GetMapping("/getMedication")
    public Result getMedication(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                Long dog_id, Long staff_id, String dosage, String notes,
                              @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate medication_time_start,
                              @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate medication_time_end){
        log.info("Medication querying with parameter: with page: {}, pageSize: {}, dog_id: {}, staff_id:{}  grooming_date between {} and {},"
                ,page, pageSize ,dog_id, staff_id, medication_time_start, medication_time_end);

        return Result.success(dogPageService.getMedication(page, pageSize,dog_id, staff_id, dosage,medication_time_start, medication_time_end, notes));
    }

    @DeleteMapping("/deleteExercise/{ids}")
    public Result deleteExercise(@PathVariable List<Long> ids){
        log.info("removing from exercise with dog_id: {} ", ids);
        dogPageService.deleteExercise(ids);
        return Result.success();
    }

    @DeleteMapping("/deleteGrooming/{ids}")
    public Result deleteGrooming(@PathVariable List<Long> ids){
        log.info("removing from Grooming with dog_id: {} ", ids);
        dogPageService.deleteGrooming(ids);
        return Result.success();
    }

    @DeleteMapping("/deleteMedication/{ids}")
    public Result deleteMedication(@PathVariable List<Long> ids){
        log.info("removing from Medication with dog_id: {} ", ids);
        dogPageService.deleteMedication(ids);
        return Result.success();
    }

    @DeleteMapping("/deleteFeeding/{ids}")
    public Result deleteFeeding(@PathVariable List<Long> ids){
        log.info("removing from Feeding with dog_id: {} ", ids);
        dogPageService.deleteFeeding(ids);
        return Result.success();
    }





    @PostMapping("/feed")
    public Result feed(@RequestBody FeedingRequest feedingRequest){
        log.info(feedingRequest.toString());
        dogPageService.feed(feedingRequest);
        return Result.success();
    }

    @PostMapping("/exercise")
    public Result exercise(@RequestBody ExerciseRequest exerciseRequest){
       log.info(exerciseRequest.toString());
       dogPageService.exercise(exerciseRequest);
       return Result.success();
    }

    @PostMapping("/grooming")
    public Result grooming(@RequestBody GroomingRequest groomingRequest){
        log.info(groomingRequest.toString());
        dogPageService.grooming(groomingRequest);
        return Result.success();
    }

    @PostMapping("/health")
    public Result health(@RequestBody HealthRequest healthRequest){
        log.info(healthRequest.toString());
        dogPageService.health(healthRequest);
        return Result.success();
    }

    @PostMapping("/medication")
    public Result medication(@RequestBody MedicationRequest medicationRequest){
        log.info(medicationRequest.toString());
        dogPageService.medication(medicationRequest);
        return Result.success();
    }

}
