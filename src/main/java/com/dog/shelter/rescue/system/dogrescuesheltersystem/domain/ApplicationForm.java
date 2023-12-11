package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class ApplicationForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long adopter_id;
    private Long dog_id;

    private String reason;
    private String status;

    private LocalDateTime interview_date;
    private LocalDateTime created_date;

    public ApplicationForm(){}

    public ApplicationForm(Long id, Long adopter_id, Long dog_id, String reason, String status, LocalDateTime interview_date, LocalDateTime created_date) {
        this.id = id;
        this.adopter_id = adopter_id;
        this.dog_id = dog_id;
        this.reason = reason;
        this.status = status;
        this.interview_date = interview_date;
        this.created_date = created_date;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdopter_id() {
        return adopter_id;
    }

    public void setAdopter_id(Long adopter_id) {
        this.adopter_id = adopter_id;
    }

    public Long getDog_id() {
        return dog_id;
    }

    public void setDog_id(Long dog_id) {
        this.dog_id = dog_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getInterview_date() {
        return interview_date;
    }

    public void setInterview_date(LocalDateTime interview_date) {
        this.interview_date = interview_date;
    }

    @Override
    public String toString() {
        return "ApplicationForm{" +
                "id=" + id +
                ", adopter_id=" + adopter_id +
                ", dog_id=" + dog_id +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                ", interview_date=" + interview_date +
                '}';
    }
}
