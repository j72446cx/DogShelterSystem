package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.*;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Request.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface DogPageService {

    DogPageBean page(Integer page, Integer pageSize,
                     Long id, String species, String adoptStatus,
                     Integer age, String gender,
                     LocalDate entryStartDate,
                     LocalDate entryEndDate,
                     LocalDate adoptedStartDate,
                     LocalDate adoptedEndDate,
                     LocalDate vaccineStartDate,
                     LocalDate vaccineEndDate,
                     LocalDate lastUpdateTimeStart,
                     LocalDate lastUpdateTimeEnd);

    void delete(List<Long> ids);

    void save(Dog dog);

    void edit(Dog dog);

    Dog getById(Long id);

    void feed(FeedingRequest feedingRequest);

    void exercise(ExerciseRequest exerciseRequest);

    void grooming(GroomingRequest groomingRequest);

    void health(HealthRequest healthRequest);

    void medication(MedicationRequest medicationRequest);

    DogPageBean getFeed(Integer page, Integer pageSize, Long dog_id, Long staff_id, LocalDate feeding_time_start, LocalDate feeding_time_end, Integer normal_feed, Long id);

    DogPageBean getGrooming(Integer page, Integer pageSize, Long dog_id, Long staff_id, LocalDate grooming_time_start, LocalDate grooming_time_end);

    DogPageBean getExercise(Integer page, Integer pageSize,Long dog_id, Long staff_id, LocalDate exercise_time_start, LocalDate exercise_time_end);
    DogPageBean getMedication(Integer page, Integer pageSize,Long dog_id, Long staff_id, String dosage,LocalDate medication_time_start, LocalDate medication_time_end, String notes);

    void deleteExercise(List<Long> ids);

    void deleteGrooming(List<Long> ids);

    void deleteMedication(List<Long> ids);

    void deleteFeeding(List<Long> ids);

    List<Staff> dogGetStaff(Long id);

    void feedNormal(Long feedingRequests, Integer normal, String notes);
}
