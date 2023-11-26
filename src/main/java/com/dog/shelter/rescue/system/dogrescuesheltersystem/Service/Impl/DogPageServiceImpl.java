package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.Impl;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.DogPageRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.DogPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.*;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Request.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class DogPageServiceImpl implements DogPageService {

    @Autowired
    private DogPageRepository dogPageRepository;

    @Override
    public DogPageBean page(Integer page, Integer pageSize,
                            Long id, String species, String adoptStatus,
                            Integer age, String gender,
                            LocalDate entryStartDate,
                            LocalDate entryEndDate,
                            LocalDate adoptedStartDate,
                            LocalDate adoptedEndDate,
                            LocalDate vaccineStartDate,
                            LocalDate vaccineEndDate,
                            LocalDate lastUpdateTimeStart,
                            LocalDate lastUpdateTimeEnd
    ){

        PageHelper.startPage(page, pageSize);

        List<Dog> dogList = dogPageRepository.list(id, species, adoptStatus, age, gender,
                entryStartDate,
                entryEndDate,
                adoptedStartDate,
                adoptedEndDate,
                vaccineStartDate,
                vaccineEndDate, lastUpdateTimeStart, lastUpdateTimeEnd);
        Page<Dog> dogPage = (Page<Dog>) dogList;

        // Encapsulate PageBean
        return new DogPageBean(dogPage.getTotal(), dogPage.getResult());

    }

    @Override
    public void deleteExercise(List<Long> ids){dogPageRepository.deleteExercise(ids);}

    @Override
    public void deleteGrooming(List<Long> ids){dogPageRepository.deleteGrooming(ids);}

    @Override
    public void deleteFeeding(List<Long> ids){dogPageRepository.deleteFeeding(ids);}

    @Override
    public void deleteMedication(List<Long> ids){dogPageRepository.deleteMedication(ids);}

    @Transactional
    @Override
    public void delete(List<Long> ids) {
        dogPageRepository.deleteFeeding(ids);
        dogPageRepository.deleteGrooming(ids);
        dogPageRepository.deleteMedication(ids);
        dogPageRepository.deleteExercise(ids);
        dogPageRepository.delete(ids);
    }

    @Override
    public void save(Dog dog) {
        dog.setEntryDate(LocalDateTime.now());
        dog.setLastUpdateTime(LocalDateTime.now());
        dogPageRepository.insert(dog);
    }

    @Override
    public void edit(Dog dog){
        dog.setLastUpdateTime(LocalDateTime.now());
        dogPageRepository.edit(dog);
    }

    @Override
    public Dog getById(Long id){

//        Dog dog = dogPageRepository.getById(id);
    return dogPageRepository.getById(id);
    }

    @Override
    public void feed(FeedingRequest feedingRequest){
        feedingRequest.setFeeding_time(LocalDateTime.now());
        dogPageRepository.feed(feedingRequest);
    }

    @Override
    public void exercise(ExerciseRequest exerciseRequest){
        dogPageRepository.exercise(exerciseRequest);
    }

    @Override
    public void grooming(GroomingRequest groomingRequest){
        dogPageRepository.grooming(groomingRequest);
    }

    @Override
    public void health(HealthRequest healthRequest){
        dogPageRepository.health(healthRequest);
    }

    @Override
    public void medication(MedicationRequest medicationRequest){
        dogPageRepository.medication(medicationRequest);
    }


    @Override
    public DogPageBean getFeed(Integer page, Integer pageSize, Long dog_id, Long staff_id, LocalDate feeding_time_start, LocalDate feeding_time_end) {
        PageHelper.startPage(page, pageSize);
        List<FeedingRequest> list =  dogPageRepository.getFeed(dog_id, staff_id, feeding_time_start,feeding_time_end);
        Page<FeedingRequest> feedpage = (Page<FeedingRequest>) list;
        return new DogPageBean(feedpage.getTotal(), feedpage.getResult());
    }

    @Override
    public DogPageBean getGrooming(Integer page, Integer pageSize,Long dog_id, Long staff_id, LocalDate grooming_time_start, LocalDate grooming_time_end) {
        PageHelper.startPage(page, pageSize);
        List<GroomingRequest> list =  dogPageRepository.getGrooming(dog_id, staff_id, grooming_time_start, grooming_time_end);
        Page<GroomingRequest> groomingRequests = (Page<GroomingRequest>) list;
        return new DogPageBean(groomingRequests.getTotal(), groomingRequests.getResult());
    }

    @Override
    public DogPageBean getExercise(Integer page, Integer pageSize,Long dog_id, Long staff_id, LocalDate exercise_time_start, LocalDate exercise_time_end) {
        PageHelper.startPage(page, pageSize);
        List<ExerciseRequest> list =  dogPageRepository.getExercise(dog_id, staff_id, exercise_time_start, exercise_time_end);
        Page<ExerciseRequest> exerciseRequests = (Page<ExerciseRequest>) list;
        return new DogPageBean(exerciseRequests.getTotal(), exerciseRequests.getResult());
    }

    @Override
    public DogPageBean getMedication(Integer page, Integer pageSize,Long dog_id, Long staff_id, String dosage,LocalDate medication_time_start, LocalDate medication_time_end, String notes) {
        PageHelper.startPage(page, pageSize);
        List<MedicationRequest> list = dogPageRepository.getMedication(dog_id, staff_id, dosage,medication_time_start, medication_time_end, notes);
        Page<MedicationRequest> medicationRequests = (Page<MedicationRequest>) list;
        return new DogPageBean(medicationRequests.getTotal(), medicationRequests.getResult());
    }

    @Override
    public List<Staff> dogGetStaff(Long id){
        return dogPageRepository.dogGetStaff(id);
    }
}
