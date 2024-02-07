package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Request;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Staff;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class FeedingRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long dog_id;
    private Long staff_id;
    private String food_type;
    private double quantity;
    private String notes;
    private LocalDateTime feeding_time;
    private int normal_feed;

    public FeedingRequest(){};

    public FeedingRequest(Long id, Long dog_id, Long staff_id, String food_type, double quantity, String notes, LocalDateTime feeding_time, int normal_feed){
        this.id = id;
        this.dog_id = dog_id;
        this.staff_id = staff_id;
        this.food_type = food_type;
        this.quantity = quantity;
        this.notes = notes;
        this.feeding_time = feeding_time;
        this.normal_feed = normal_feed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNormal_feed() {
        return normal_feed;
    }

    public void setNormal_feed(int normal_feed) {
        this.normal_feed = normal_feed;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getFeeding_time() {
        return feeding_time;
    }

    public void setFeeding_time(LocalDateTime feeding_time) {
        this.feeding_time = feeding_time;
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

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String toString() {
        return "FeedingRequest{" +
                "dogId=" + dog_id +
                ", staffId=" + staff_id +
                ", feedingTime=" + feeding_time+
                ", foodType='" + food_type + '\'' +
                ", foodAmount=" + quantity +
                '}';
    }
}
