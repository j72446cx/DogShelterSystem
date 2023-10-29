package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.DogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping
    public List<Dog> getAllDogs() {
        log.info("Querying for all dogs in the database");
        return dogService.getAllDogs();
    }

    @GetMapping("/{id}")
    public Dog getDogById(@PathVariable long id) {
        log.info("Querying for the dog with id: " + id);
        return dogService.getDogById(id);
    }

    @PostMapping
    public Boolean addDog(@RequestBody Dog dog) {
        Boolean temp = dogService.addDog(dog);
        log.info("Adding dog into the database, with id: " + dog.getId() + ". Result: "+temp);
        return temp;
    }

    @PutMapping("/{id}")
    public Boolean updateDog(@PathVariable long id, @RequestBody Dog updatedDog) {

        Boolean temp = dogService.updateDog(id, updatedDog);
        log.info("Updating the information of the dog with id: " + id + ". Result: " + temp);
        return temp;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteDog(@PathVariable long id) {
        log.info("Deleting the dog with id: "+ id +" from database");
        return dogService.deleteDog(id);
    }
}
