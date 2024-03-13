package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.DogPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Result;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dogpage")
public class DogPageController {

    @Autowired
    private DogPageService dogPageService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            Integer age, String gender, Long id,
                            String species, String adoptStatus,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate entryStartDate,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate entryEndDate,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate adoptedStartDate,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate adoptedEndDate,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate vaccineStartDate,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate vaccineEndDate,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate lastUpdateTimeStart,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate lastUpdateTimeEnd,
                       Boolean is_neutered){
        log.info("Page querying with parameter: with page: {} and pageSize: {}, id: {}, age: {}, gender: {}, " +
                        "entryDate between {} and {}, adoptedDate between {} and {}, vaccineDate between {} and {}," +
                        " lastUpdateTime between {} and {}, is_neutered: {}",
                page, pageSize, id,
                age, gender,
                entryStartDate, entryEndDate,
                adoptedStartDate,adoptedEndDate,
                vaccineStartDate, vaccineEndDate,
                lastUpdateTimeStart, lastUpdateTimeEnd, is_neutered);

        return Result.success(dogPageService.page(
                page, pageSize, id, species, adoptStatus,
                age, gender,
                entryStartDate, entryEndDate,
                adoptedStartDate, adoptedEndDate,
                vaccineStartDate, vaccineEndDate, lastUpdateTimeStart, lastUpdateTimeEnd, is_neutered));

    }

    @GetMapping("/{ids}")
    public Result getById(@PathVariable Long ids){
        log.info("Querying dog by id: {}", ids);
        Dog dog1 = dogPageService.getById(ids);
        return Result.success(dog1);
    }

    @DeleteMapping("delete/{ids}")
    public Result delete(@PathVariable List<Long> ids){
        log.info("Batch removing with id: {}", ids);
        dogPageService.delete(ids);
        return Result.success();
    }

    @PostMapping("/save")
    public Result save(@RequestBody Dog dog){
        log.info("Adding dog :{}", dog);
        dogPageService.save(dog);
        return Result.success();
    }

    @PutMapping("/edit")
    public Result edit(@RequestBody Dog dog){
        log.info("Editing dog: {}", dog);
        dogPageService.edit(dog);
        return Result.success();
    }

}
