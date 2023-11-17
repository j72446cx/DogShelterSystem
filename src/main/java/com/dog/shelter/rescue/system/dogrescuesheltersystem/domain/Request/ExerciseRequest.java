package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Request;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Staff;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExerciseRequest {

//    private Dog dog;
//    private Staff staff;
    private Long dog_id;
    private Long staff_id;
    private String duration;
    private LocalDateTime date;
    private String exerciseType;
    private String notes;

    public ExerciseRequest(){};

    public ExerciseRequest(Long dog_id, Long staff_id, String duration, LocalDateTime date, String exerciseType, String notes){
        this.dog_id = dog_id;
        this.staff_id = staff_id;
        this.duration = duration;
        this.date = date;
        this.exerciseType = exerciseType;
        this.notes = notes;
    }



    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getDog_id() {
        return dog_id;
    }

    public void setDog_id(Long dog_id) {
        this.dog_id = dog_id;
    }

    public Long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Long staff_id) {
        this.staff_id = staff_id;
    }

    @Override
    public String toString() {
        return "ExerciseRequest{" +
                "dog id =" + dog_id +
                ", staff id=" + staff_id +
                ", duration='" + duration + '\'' +
                ", date=" + date +
                ", exerciseType='" + exerciseType + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
