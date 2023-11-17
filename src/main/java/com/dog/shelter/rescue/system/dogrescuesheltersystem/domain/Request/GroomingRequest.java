package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Request;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Staff;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

public class GroomingRequest {

    private Long dog_id;
    private Long staff_id;
    private LocalDateTime grooming_date;
    private String type;
    private String notes;

    public GroomingRequest(){};

    public GroomingRequest(Long dog_id, Long staff_id, LocalDateTime grooming_date, String type, String notes){
        this.dog_id = dog_id;
        this.staff_id = staff_id;
        this.grooming_date = grooming_date;
        this.type = type;
        this.notes = notes;
    }

    public LocalDateTime getGrooming_date() {
        return grooming_date;
    }

    public void setGrooming_date(LocalDateTime grooming_date) {
        this.grooming_date = grooming_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "GroomingRequest{" +
                "dog id =" + dog_id +
                ", staff id =" + staff_id +
                ", grooming_date=" + grooming_date +
                ", type='" + type + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
