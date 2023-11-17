package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int age;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
    private String address;
    private String postCode;
    private String role;
    private LocalDateTime dateOfBirth;
    private String gender;
    private LocalDateTime entryDate;
    private float salary;
    private String emergency_Contact;
    private String avatar;
    private LocalDateTime contractStartDate;
    private LocalDateTime contractEndDate;
    private String username;
    private String password;
    private String contractImg;
    private String identityPhoto;
    private String identification;
    private LocalDateTime lastUpdateTime;

    public Staff(){};

    public Staff(String firstName, String lastName,
                 String middleName, String gender,
                Integer age, String email,
                 String phoneNumber, String address,
                 String postCode, String role,
                 LocalDateTime dateOfBirth, LocalDateTime entryDate,
                 LocalDateTime contractStartDate, LocalDateTime contractEndDate,
                 Float salary, String emergency_Contact,
                 String avatar, String identityPhoto, String contractImg,
                 String username, String password, String identification,
                 LocalDateTime lastUpdateTime){

        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.postCode = postCode;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.entryDate = entryDate;
        this.salary = salary;
        this.emergency_Contact = emergency_Contact;
        this.avatar = avatar;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.username = username;
        this.password = password;
        this.contractImg = contractImg;
        this.identityPhoto = identityPhoto;
        this.identification = identification;
        this.lastUpdateTime = lastUpdateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getEmergency_Contact() {
        return emergency_Contact;
    }

    public void setEmergency_Contact(String emergency_Contact) {
        this.emergency_Contact = emergency_Contact;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDateTime getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDateTime contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDateTime getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDateTime contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContractImg() {
        return contractImg;
    }

    public void setContractImg(String contractImg) {
        this.contractImg = contractImg;
    }

    public String getPhoto() {
        return identityPhoto;
    }

    public void setPhoto(String photo) {
        this.identityPhoto = photo;
    }

    public String getIdentityPhoto() {
        return identityPhoto;
    }

    public void setIdentityPhoto(String identityPhoto) {
        this.identityPhoto = identityPhoto;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
