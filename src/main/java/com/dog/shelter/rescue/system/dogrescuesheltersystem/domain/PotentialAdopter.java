package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain;

import javax.persistence.*;

@Entity
public class PotentialAdopter {
    @Id
    private Long id;

    private Integer householdMembers;
    private Boolean children;
    private Boolean otherPets;
    private String housingType;
    private String housingStability;
    private Boolean landlordConsent;
    @Column(length = 1000)
    private String workStudySchedule;
    @Column(length = 1000)
    private String dailyActivities;
    private String incomeLevel;
    private Boolean petInsurance;
    private Boolean previousPetOwnership;
    @Column(length = 1000)
    private String petCareKnowledge;
    @Column(length = 1000)
    private String petPreference;
    private String adoptionPurpose;
    @Column(length = 1000)
    private String emergencyPlan;
    @Column(length = 1000)
    private String referencePerson;
    private Boolean agreementCompliance;
    private Boolean postAdoptionSupportCommitment;
    private String landlordContact;

    private String living_room;
    private String garden;
    private String balcony;
    private String kitchen;
    private String family_photo;
    private String preparation;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Customer customer;

    public PotentialAdopter(){}

    public PotentialAdopter(Long id, Integer householdMembers, Boolean children, Boolean otherPets, String housingType, String housingStability, Boolean landlordConsent, String workStudySchedule, String dailyActivities, String incomeLevel, Boolean petInsurance, Boolean previousPetOwnership, String petCareKnowledge, String petPreference, String adoptionPurpose, String emergencyPlan, String referencePerson, Boolean agreementCompliance, Boolean postAdoptionSupportCommitment, String landlordContact, String living_room, String garden, String balcony, String kitchen, String family_photo, String preparation, Customer customer) {
        this.id = id;
        this.householdMembers = householdMembers;
        this.children = children;
        this.otherPets = otherPets;
        this.housingType = housingType;
        this.housingStability = housingStability;
        this.landlordConsent = landlordConsent;
        this.workStudySchedule = workStudySchedule;
        this.dailyActivities = dailyActivities;
        this.incomeLevel = incomeLevel;
        this.petInsurance = petInsurance;
        this.previousPetOwnership = previousPetOwnership;
        this.petCareKnowledge = petCareKnowledge;
        this.petPreference = petPreference;
        this.adoptionPurpose = adoptionPurpose;
        this.emergencyPlan = emergencyPlan;
        this.referencePerson = referencePerson;
        this.agreementCompliance = agreementCompliance;
        this.postAdoptionSupportCommitment = postAdoptionSupportCommitment;
        this.landlordContact = landlordContact;
        this.living_room = living_room;
        this.garden = garden;
        this.balcony = balcony;
        this.kitchen = kitchen;
        this.family_photo = family_photo;
        this.preparation = preparation;
        this.customer = customer;
    }

    public String getLiving_room() {
        return living_room;
    }

    public void setLiving_room(String living_room) {
        this.living_room = living_room;
    }

    public String getGarden() {
        return garden;
    }

    public void setGarden(String garden) {
        this.garden = garden;
    }

    public String getBalcony() {
        return balcony;
    }

    public void setBalcony(String balcony) {
        this.balcony = balcony;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    public String getFamily_photo() {
        return family_photo;
    }

    public void setFamily_photo(String family_photo) {
        this.family_photo = family_photo;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getLandlordContact() {
        return landlordContact;
    }

    public void setLandlordContact(String landlordContact) {
        this.landlordContact = landlordContact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHouseholdMembers() {
        return householdMembers;
    }

    public void setHouseholdMembers(Integer householdMembers) {
        this.householdMembers = householdMembers;
    }

    public Boolean getChildren() {
        return children;
    }

    public void setChildren(Boolean children) {
        this.children = children;
    }

    public Boolean getOtherPets() {
        return otherPets;
    }

    public void setOtherPets(Boolean otherPets) {
        this.otherPets = otherPets;
    }

    public String getHousingType() {
        return housingType;
    }

    public void setHousingType(String housingType) {
        this.housingType = housingType;
    }

    public String getHousingStability() {
        return housingStability;
    }

    public void setHousingStability(String housingStability) {
        this.housingStability = housingStability;
    }

    public Boolean getLandlordConsent() {
        return landlordConsent;
    }

    public void setLandlordConsent(Boolean landlordConsent) {
        this.landlordConsent = landlordConsent;
    }

    public String getWorkStudySchedule() {
        return workStudySchedule;
    }

    public void setWorkStudySchedule(String workStudySchedule) {
        this.workStudySchedule = workStudySchedule;
    }

    public String getDailyActivities() {
        return dailyActivities;
    }

    public void setDailyActivities(String dailyActivities) {
        this.dailyActivities = dailyActivities;
    }

    public String getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(String incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    public Boolean getPetInsurance() {
        return petInsurance;
    }

    public void setPetInsurance(Boolean petInsurance) {
        this.petInsurance = petInsurance;
    }

    public Boolean getPreviousPetOwnership() {
        return previousPetOwnership;
    }

    public void setPreviousPetOwnership(Boolean previousPetOwnership) {
        this.previousPetOwnership = previousPetOwnership;
    }

    public String getPetCareKnowledge() {
        return petCareKnowledge;
    }

    public void setPetCareKnowledge(String petCareKnowledge) {
        this.petCareKnowledge = petCareKnowledge;
    }

    public String getPetPreference() {
        return petPreference;
    }

    public void setPetPreference(String petPreference) {
        this.petPreference = petPreference;
    }

    public String getAdoptionPurpose() {
        return adoptionPurpose;
    }

    public void setAdoptionPurpose(String adoptionPurpose) {
        this.adoptionPurpose = adoptionPurpose;
    }

    public String getEmergencyPlan() {
        return emergencyPlan;
    }

    public void setEmergencyPlan(String emergencyPlan) {
        this.emergencyPlan = emergencyPlan;
    }

    public String getReferencePerson() {
        return referencePerson;
    }

    public void setReferencePerson(String referencePerson) {
        this.referencePerson = referencePerson;
    }

    public Boolean getAgreementCompliance() {
        return agreementCompliance;
    }

    public void setAgreementCompliance(Boolean agreementCompliance) {
        this.agreementCompliance = agreementCompliance;
    }

    public Boolean getPostAdoptionSupportCommitment() {
        return postAdoptionSupportCommitment;
    }

    public void setPostAdoptionSupportCommitment(Boolean postAdoptionSupportCommitment) {
        this.postAdoptionSupportCommitment = postAdoptionSupportCommitment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "PotentialAdopter{" +
                "id=" + id +
                ", householdMembers=" + householdMembers +
                ", children=" + children +
                ", otherPets=" + otherPets +
                ", housingType='" + housingType + '\'' +
                ", housingStability='" + housingStability + '\'' +
                ", landlordConsent=" + landlordConsent +
                ", workStudySchedule='" + workStudySchedule + '\'' +
                ", dailyActivities='" + dailyActivities + '\'' +
                ", incomeLevel='" + incomeLevel + '\'' +
                ", petInsurance=" + petInsurance +
                ", previousPetOwnership=" + previousPetOwnership +
                ", petCareKnowledge='" + petCareKnowledge + '\'' +
                ", petPreference='" + petPreference + '\'' +
                ", adoptionPurpose='" + adoptionPurpose + '\'' +
                ", emergencyPlan='" + emergencyPlan + '\'' +
                ", referencePerson='" + referencePerson + '\'' +
                ", agreementCompliance=" + agreementCompliance +
                ", postAdoptionSupportCommitment=" + postAdoptionSupportCommitment +
                ", landlordContact='" + landlordContact + '\'' +
                ", living_room='" + living_room + '\'' +
                ", garden='" + garden + '\'' +
                ", balcony='" + balcony + '\'' +
                ", kitchen='" + kitchen + '\'' +
                ", family_photo='" + family_photo + '\'' +
                ", preparation='" + preparation + '\'' +
                ", customer=" + customer +
                '}';
    }
}
