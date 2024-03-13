package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReviewingForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long application_id;
    private Long staff_id;

    private String customer_info_notes;
    private String form_info_notes;
    private String family_member_notes;
    private String residence_info_notes;
    private String personal_background_notes;
    private String dog_care_notes;
    private String overall_notes;

    public ReviewingForm(){}

    public ReviewingForm(Long id, Long application_id, Long staff_id, String customer_info_notes, String form_info_notes, String family_member_notes, String residence_info_notes, String personal_background_notes, String dog_care_notes, String overall_notes) {
        this.id = id;
        this.application_id = application_id;
        this.staff_id = staff_id;
        this.customer_info_notes = customer_info_notes;
        this.form_info_notes = form_info_notes;
        this.family_member_notes = family_member_notes;
        this.residence_info_notes = residence_info_notes;
        this.personal_background_notes = personal_background_notes;
        this.dog_care_notes = dog_care_notes;
        this.overall_notes = overall_notes;
    }

    public Long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Long staff_id) {
        this.staff_id = staff_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApplication_id() {
        return application_id;
    }

    public void setApplication_id(Long application_id) {
        this.application_id = application_id;
    }

    public String getCustomer_info_notes() {
        return customer_info_notes;
    }

    public void setCustomer_info_notes(String customer_info_notes) {
        this.customer_info_notes = customer_info_notes;
    }

    public String getForm_info_notes() {
        return form_info_notes;
    }

    public void setForm_info_notes(String form_info_notes) {
        this.form_info_notes = form_info_notes;
    }

    public String getFamily_member_notes() {
        return family_member_notes;
    }

    public void setFamily_member_notes(String family_member_notes) {
        this.family_member_notes = family_member_notes;
    }

    public String getResidence_info_notes() {
        return residence_info_notes;
    }

    public void setResidence_info_notes(String residence_info_notes) {
        this.residence_info_notes = residence_info_notes;
    }

    public String getPersonal_background_notes() {
        return personal_background_notes;
    }

    public void setPersonal_background_notes(String personal_background_notes) {
        this.personal_background_notes = personal_background_notes;
    }

    public String getDog_care_notes() {
        return dog_care_notes;
    }

    public void setDog_care_notes(String dog_care_notes) {
        this.dog_care_notes = dog_care_notes;
    }

    public String getOverall_notes() {
        return overall_notes;
    }

    public void setOverall_notes(String overall_notes) {
        this.overall_notes = overall_notes;
    }

    @Override
    public String toString() {
        return "ReviewingForm{" +
                "id=" + id +
                ", application_id=" + application_id +
                ", customer_info_notes='" + customer_info_notes + '\'' +
                ", form_info_notes='" + form_info_notes + '\'' +
                ", family_member_notes='" + family_member_notes + '\'' +
                ", residence_info_notes='" + residence_info_notes + '\'' +
                ", personal_background_notes='" + personal_background_notes + '\'' +
                ", dog_care_notes='" + dog_care_notes + '\'' +
                ", overall_notes='" + overall_notes + '\'' +
                '}';
    }
}
