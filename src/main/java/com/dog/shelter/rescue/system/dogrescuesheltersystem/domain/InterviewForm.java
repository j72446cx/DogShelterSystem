package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InterviewForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long application_id;
    private Long staff_id;

    /*
    * Building the bond
    */

    private String body_language;
    private String intimate_contact;
    private String eye_contact;
    private String play;
    private String response_instruction;
    private String summary;

    public InterviewForm(){}

    public InterviewForm(Long id, Long application_id, Long dog_id, Long staff_id, String body_language, String intimate_contact, String eye_contact, String play, String response_instruction, String summary) {
        this.id = id;
        this.application_id = application_id;

        this.staff_id = staff_id;
        this.body_language = body_language;
        this.intimate_contact = intimate_contact;
        this.eye_contact = eye_contact;
        this.play = play;
        this.response_instruction = response_instruction;
        this.summary = summary;
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

    public Long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Long staff_id) {
        this.staff_id = staff_id;
    }

    public String getBody_language() {
        return body_language;
    }

    public void setBody_language(String body_language) {
        this.body_language = body_language;
    }

    public String getIntimate_contact() {
        return intimate_contact;
    }

    public void setIntimate_contact(String intimate_contact) {
        this.intimate_contact = intimate_contact;
    }

    public String getEye_contact() {
        return eye_contact;
    }

    public void setEye_contact(String eye_contact) {
        this.eye_contact = eye_contact;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public String getResponse_instruction() {
        return response_instruction;
    }

    public void setResponse_instruction(String response_instruction) {
        this.response_instruction = response_instruction;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "InterviewForm{" +
                "id=" + id +
                ", application_id=" + application_id +
                ", staff_id=" + staff_id +
                ", body_language='" + body_language + '\'' +
                ", intimate_contact='" + intimate_contact + '\'' +
                ", eye_contact='" + eye_contact + '\'' +
                ", play='" + play + '\'' +
                ", response_instruction='" + response_instruction + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
