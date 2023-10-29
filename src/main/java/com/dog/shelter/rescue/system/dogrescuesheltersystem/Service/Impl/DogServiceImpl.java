package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.Impl;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.DogRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    @Autowired
    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    @Override
    public Dog getDogById(long id) {
        return dogRepository.findById(id);
    }

    @Override
    public Boolean addDog(Dog dog) {

        return dogRepository.save(dog);
    }

    @Override
    public Boolean updateDog(long id, Dog updatedDog) {
        if (dogRepository.existsById(id)) {
            return dogRepository.updatingDog(id, updatedDog);

        }
        return false;
    }

    @Override
    public Boolean deleteDog(long id) {
        return dogRepository.deleteById(id);
    }

    @Override
    public List<Dog> findDogsBySpecies(String species){
        return dogRepository.findDogsBySpecies(species);
    }

    @Override
    public String findNameById(long id){
        return dogRepository.getNameById(id);
    }

    @Override
    public String findURLbyId(long id){
        return dogRepository.getURLById(id);
    }

    @Override
    public String findSpeciesById(long id){
        return dogRepository.getSpeciesById(id);
    }

    @Override
    public String findAdoptStatusById(long id){
        return dogRepository.getStatusById(id);
    }

    @Override
    public String findMedicalById(long id){
        return dogRepository.getMedicalById(id);
    }

    @Override
    public String findIntroById(long id){
        return dogRepository.getIntroById(id);
    }

    @Override
    public int findAgeById(long id){
        return dogRepository.getAgeById(id);
    }

    @Override
    public boolean clean_database(){return dogRepository.cleaning_database();}

}

