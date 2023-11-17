package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Request;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Staff;

import java.time.LocalDateTime;

public class HealthRequest {

    private Long dog_id;
    private Long staff_id;
    private LocalDateTime checkup_date;
    private double weight;
    private String health_status;
    private String notes;

    public HealthRequest(){};

    public HealthRequest(Long dog_id, Long staff_id, LocalDateTime checkup_date, double weight, String health_status, String notes){
        this.dog_id = dog_id;
        this.staff_id = staff_id;
        this.checkup_date = checkup_date;
        this.weight = weight;
        this.health_status = health_status;
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

    public LocalDateTime getCheckup_date() {
        return checkup_date;
    }

    public void setCheckup_date(LocalDateTime checkup_date) {
        this.checkup_date = checkup_date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHealth_status() {
        return health_status;
    }

    public void setHealth_status(String health_status) {
        this.health_status = health_status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "HealthRequest{" +
                "dog id=" + dog_id +
                ", staff id=" + staff_id +
                ", checkup_date=" + checkup_date +
                ", weight=" + weight +
                ", health_status='" + health_status + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
