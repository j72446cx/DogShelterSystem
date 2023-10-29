package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;

import java.util.List;

public interface DogService {

    List<Dog> getAllDogs();

    Dog getDogById(long id);

    Boolean addDog(Dog dog);

    Boolean updateDog(long id, Dog updatedDog);

    Boolean deleteDog(long id);

    List<Dog> findDogsBySpecies(String species);

    String findNameById(long id);

    String findURLbyId(long id);

    String findSpeciesById(long id);

    String findAdoptStatusById(long id);

    String findMedicalById(long id);

    String findIntroById(long id);

    int findAgeById(long id);

    boolean clean_database();

}
