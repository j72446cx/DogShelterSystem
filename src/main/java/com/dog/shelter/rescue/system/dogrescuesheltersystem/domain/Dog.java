package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain;

import javax.persistence.*;

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


    public Dog() {
        // Default constructor
    }

    public Dog(String name, int age, String imgURL, String species, String AdoptStatus, String MedicalHistory, String intro, String gender) {
        this.name = name;
        this.age = age;
        this.imgURL = imgURL;
        this.MedicalHistory = MedicalHistory;
        this.intro = intro;
        this.AdoptStatus = AdoptStatus;
        this.species = species;
        this.gender = gender;
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
}
