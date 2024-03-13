package com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Request.*;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Staff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface DogPageRepository {


    List<Dog> list(Long id, String species, String adoptStatus, Integer age, String gender,
                          LocalDate entryStartDate,
                          LocalDate entryEndDate,
                          LocalDate adoptedStartDate,
                          LocalDate adoptedEndDate,
                          LocalDate vaccineStartDate,
                          LocalDate vaccineEndDate,
                   LocalDate lastUpdateTimeStart,
                   LocalDate lastUpdateTimeEnd,
                   Boolean is_neutered
                   );

    void delete(List<Long> ids);

    @Insert("INSERT INTO Dog (name, age, imgURL, species, AdoptStatus, MedicalHistory, intro, gender, EntryDate, AdoptedDate, LastVaccineDate, LastUpdateTime, is_neutered) VALUES (#{name}, #{age}, #{imgURL}, #{species}, #{AdoptStatus}, #{MedicalHistory}, #{intro}, #{gender}, #{EntryDate}, #{AdoptedDate}, #{LastVaccineDate}, #{LastUpdateTime}, #{is_neutered})")
    void insert(Dog dog);

    void edit(Dog dog);

    @Select("select * from Dog where id = #{id}")
    Dog getById(Long id);

    void feed(FeedingRequest feedingRequest);

    void exercise(ExerciseRequest exerciseRequest);

    void grooming(GroomingRequest groomingRequest);

    void health(HealthRequest healthRequest);

    void medication(MedicationRequest medicationRequest);

    List<FeedingRequest> getFeed(Long dog_id, Long staff_id, LocalDate feeding_time_start, LocalDate feeding_time_end, Integer normal_feed, Long id);

    List<GroomingRequest> getGrooming(Long dog_id, Long staff_id, LocalDate grooming_time_start, LocalDate grooming_time_end);

    List<ExerciseRequest> getExercise(Long dog_id, Long staff_id, LocalDate exercise_time_start, LocalDate exercise_time_end);

    List<MedicationRequest> getMedication(Long dog_id, Long staff_id, String dosage, LocalDate medication_time_start, LocalDate medication_time_end, String notes);

    void deleteExercise(List<Long> ids);

    void deleteGrooming(List<Long> ids);

    void deleteFeeding(List<Long> ids);

    void deleteMedication(List<Long> ids);



    @Select("SELECT s.* FROM Staff s INNER JOIN Staff_Dog sd ON s.id = sd.staff_id WHERE sd.dog_id = #{id}")
    List<Staff> dogGetStaff(Long id);

    void feedNormal(Long feedingRequests, Integer normal, String notes);

    @Insert("INSERT INTO Staff_Dog (dog_id, staff_id) VALUES(#{dog_id}, #{staff_id})")
    void assignDogToStaff(Long dog_id, Long staff_id);

    @Delete("DELETE from Staff_Dog WHERE dog_id=#{dog_id} AND staff_id=#{staff_id}")
    void deleteDogFromStaff(Long dog_id, Long staff_id);
}
