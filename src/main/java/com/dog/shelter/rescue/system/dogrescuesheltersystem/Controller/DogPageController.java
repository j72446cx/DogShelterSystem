package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.DogPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.DogPageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dogpage")
public class DogPageController {

    @Autowired
    private DogPageService dogPageService;

    @GetMapping
    public DogPageBean page(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            Integer age, String gender,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate entryStartDate,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate entryEndDate,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate adoptedStartDate,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate adoptedEndDate,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate vaccineStartDate,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate vaccineEndDate){
        log.info("Page querying with parameter: with page: {} and pageSize: {}, age: {}, gender: {}, " +
                        "entryDate between {} and {}, adoptedDate between {} and {}, vaccineDate between {} and {}",
                page, pageSize,
                age, gender,
                entryStartDate, entryEndDate,
                adoptedStartDate,adoptedEndDate,
                vaccineStartDate, vaccineEndDate);

        return dogPageService.page(
                page, pageSize,
                age, gender,
                entryStartDate, entryEndDate,
                adoptedStartDate, adoptedEndDate,
                vaccineStartDate, vaccineEndDate);

    }

    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Long> ids){
        log.info("Batch removing with id: {}", ids);
        dogPageService.delete(ids);
    }
}
