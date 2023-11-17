package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Request;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Staff;

import java.time.LocalDateTime;

public class MedicationRequest {

    private Long dog_id;
    private Long staff_id;
    private String medication_name;
    private String dosage;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String notes;

    public MedicationRequest(Long dog_id, Long staff_id, String medication_name, String dosage, LocalDateTime startDate,LocalDateTime endDate, String notes) {
        this.dog_id = dog_id;
        this.staff_id = staff_id;
        this.medication_name = medication_name;
        this.dosage = dosage;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getMedication_name() {
        return medication_name;
    }

    public void setMedication_name(String medication_name) {
        this.medication_name = medication_name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "MedicationRequest{" +
                "dog id=" + dog_id+
                ", staff id=" + staff_id+
                ", medication_name='" + medication_name + '\'' +
                ", dosage='" + dosage + '\'' +
                ", start date=" + startDate +
                ", end date= "+ endDate +
                ", notes='" + notes + '\'' +
                '}';
    }
}
