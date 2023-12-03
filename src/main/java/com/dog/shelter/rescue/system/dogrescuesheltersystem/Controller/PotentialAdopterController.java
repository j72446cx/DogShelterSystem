package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.PotentialAdopterService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.PotentialAdopter;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/adopter")
public class PotentialAdopterController {

    @Autowired
    private PotentialAdopterService potentialAdopterService;

    @PostMapping("/save")
    public Result save(@RequestBody PotentialAdopter potentialAdopter){
        log.info("New potential adopter: {}", potentialAdopter.toString());
        potentialAdopterService.save(potentialAdopter);
        return Result.success();
    }

    @GetMapping("/{ids}")
    public Result getById(@PathVariable Long ids){
        log.info("Querying potential adopter with id: {}", ids);
        PotentialAdopter potentialAdopter =  potentialAdopterService.getById(ids);
        return Result.success(potentialAdopter);
    }

    @PutMapping("/edit")
    public Result edit(@RequestBody PotentialAdopter potentialAdopter){
        log.info("Editing potential adopter: {}", potentialAdopter);
        potentialAdopterService.edit(potentialAdopter);
        return Result.success();
    }

    @DeleteMapping("/delete/{ids}")
    public Result delete(@PathVariable List<Long> ids){
        log.info("Deleteing potential adopter with ids: {}", ids);
        potentialAdopterService.delete(ids);
        return Result.success();
    }
}
