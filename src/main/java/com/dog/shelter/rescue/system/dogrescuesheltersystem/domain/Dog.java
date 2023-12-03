package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int age;
    private String imgURL;
    private String species;
    private String AdoptStatus;
    private String MedicalHistory;
    private String intro;
    private String gender;
    private LocalDateTime EntryDate;
    private LocalDateTime AdoptedDate;
    private LocalDateTime LastVaccineDate;
    private LocalDateTime LastUpdateTime;
    private LocalDateTime lastFeedTime;

    @ManyToMany(mappedBy = "dogs")
    private Set<Staff> staffs = new HashSet<>();


    public Dog() {

    }

    public Dog(long id, String name, int age, String imgURL, String species, String adoptStatus, String medicalHistory, String intro, String gender, LocalDateTime entryDate, LocalDateTime adoptedDate, LocalDateTime lastVaccineDate, LocalDateTime lastUpdateTime, LocalDateTime lastFeedTime, Set<Staff> staffs) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.imgURL = imgURL;
        this.species = species;
        AdoptStatus = adoptStatus;
        MedicalHistory = medicalHistory;
        this.intro = intro;
        this.gender = gender;
        EntryDate = entryDate;
        AdoptedDate = adoptedDate;
        LastVaccineDate = lastVaccineDate;
        LastUpdateTime = lastUpdateTime;
        this.lastFeedTime = lastFeedTime;
        this.staffs = staffs;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }
    // Getters and setters for all attributes

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getAdoptStatus() {
        return AdoptStatus;
    }

    public void setAdoptStatus(String adoptStatus) {
        this.AdoptStatus = adoptStatus;
    }

    public String getMedicalStatus() {
        return MedicalHistory;
    }

    public void setMedicalStatus(String medicalStatus) {
        MedicalHistory = medicalStatus;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getMedicalHistory() {
        return MedicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        MedicalHistory = medicalHistory;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        EntryDate = entryDate;
    }

    public LocalDateTime getAdoptedDate() {
        return AdoptedDate;
    }

    public void setAdoptedDate(LocalDateTime adoptedDate) {
        AdoptedDate = adoptedDate;
    }

    public LocalDateTime getLastVaccineDate() {
        return LastVaccineDate;
    }

    public void setLastVaccineDate(LocalDateTime lastVaccineDate) {
        LastVaccineDate = lastVaccineDate;
    }

    public LocalDateTime getLastUpdateTime() {
        return LastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        LastUpdateTime = lastUpdateTime;
    }

    public LocalDateTime getLastFeedTime() {
        return lastFeedTime;
    }

    public void setLastFeedTime(LocalDateTime lastFeedTime) {
        this.lastFeedTime = lastFeedTime;
    }
}
