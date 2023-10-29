package com.dog.shelter.rescue.system.dogrescuesheltersystem.RepositoryTest;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller.DogController;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.DogRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.LocalTime;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class DogRescueShelterSystemApplicationTests {

    String test_name_1 = "test_lucy";
    String test_name_2 = "test_god";
    String test_species_1 = "test_husky";
    String test_species_2 = "test_border";
    String test_status_1 = "test_reserved";
    String test_status_2 = "test_available";
    String test_medical_1 = "test_vaccinated";
    String test_medical_2 = "test_none";
    String test_intro_1 = "test_good";
    String test_intro_2 = "test_verygood";
    String test_URL_1 = "testHTTP";
    String test_URL_2 = "testHTML";
    String test_URL_3 = "testHTTPs";
    String test_gender_1 = "male";
    String test_gender_2 = "female";
    LocalDateTime test_Date = LocalDateTime.now();

    /* Only species is same : */
    Dog dog1 = new Dog(test_name_1,2, test_URL_1, test_species_1,test_status_1,test_medical_1,test_intro_1,test_gender_1, test_Date, test_Date, test_Date);
    Dog dog2 = new Dog(test_name_2, 3, test_URL_2, test_species_1, test_status_2, test_medical_2, test_intro_2,test_gender_1, test_Date,test_Date,test_Date);
    Dog dog3 = new Dog(test_name_1, 4, test_URL_3, test_species_2, test_status_1,test_medical_1,test_intro_1,test_gender_2,test_Date,test_Date,test_Date);


    @Autowired
    private DogRepository dogRepository;

    @BeforeEach
    public void setup(){
        dogRepository.save(dog1);
        dogRepository.save(dog2);
        dogRepository.save(dog3);
    }
    @AfterEach
    public void retrieve(){
        dogRepository.deleteById(dog1.getId());
        dogRepository.deleteById(dog2.getId());
        dogRepository.deleteById(dog3.getId());
    }

    @Test
    public void test_AddAndDeleteDog(){
        Assertions.assertTrue(dogRepository.save(dog1));
        Assertions.assertTrue(dogRepository.deleteById(dog1.getId()));
    }

    @Test
    public void test_findAll(){

        Assertions.assertTrue(dogRepository.findAll().size() >= 2);

    }

    @Test
    public void test_findById(){

        // id is unique
        Assertions.assertEquals(dogRepository.findAll().get(dogRepository.findAll().size() - 1).getId(), dog3.getId());

    }

    @Test
    public void test_existById(){

        Assertions.assertTrue(dogRepository.existsById(dog1.getId()));
        Assertions.assertTrue(dogRepository.existsById(dog2.getId()));

    }

    @Test
    public void test_findDogsBySpecies(){

        Assertions.assertTrue(dogRepository.findDogsBySpecies(test_species_1).size() >= 2);

    }

    @Test
    public void test_getIntroById(){

        Assertions.assertEquals(dogRepository.getIntroById(dog1.getId()), test_intro_1);
        Assertions.assertEquals(dogRepository.getIntroById(dog2.getId()), test_intro_2);

    }

    @Test
    public void test_getSpeciesById(){

        Assertions.assertEquals(dogRepository.getSpeciesById(dog1.getId()), test_species_1);
        Assertions.assertEquals(dogRepository.getSpeciesById(dog2.getId()), test_species_1);
        Assertions.assertEquals(dogRepository.getSpeciesById(dog3.getId()), test_species_2);

    }

    @Test
    public void test_getNameById(){

        Assertions.assertEquals(dogRepository.getNameById(dog1.getId()), test_name_1);
        Assertions.assertEquals(dogRepository.getNameById(dog2.getId()), test_name_2);

    }

    @Test
    public void test_getURLbyId(){

        Assertions.assertEquals(dogRepository.getURLById(dog1.getId()), test_URL_1);
        Assertions.assertEquals(dogRepository.getURLById(dog2.getId()), test_URL_2);

    }

    @Test
    public void test_getStatusById(){

        Assertions.assertEquals(dogRepository.getStatusById(dog1.getId()), test_status_1);
        Assertions.assertEquals(dogRepository.getStatusById(dog2.getId()), test_status_2);

    }

    @Test
    public void test_getMedicalById(){

        Assertions.assertEquals(dogRepository.getMedicalById(dog1.getId()), test_medical_1);
        Assertions.assertEquals(dogRepository.getMedicalById(dog2.getId()), test_medical_2);

    }

    @Test
    public void test_getAgeById(){

        Assertions.assertEquals(dogRepository.getAgeById(dog1.getId()), dog1.getAge());
        Assertions.assertEquals(dogRepository.getAgeById(dog2.getId()), dog2.getAge());

    }



}
