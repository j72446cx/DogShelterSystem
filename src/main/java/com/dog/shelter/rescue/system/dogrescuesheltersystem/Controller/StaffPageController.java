package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;


import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.StaffPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Result;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Staff;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/staffpage")
public class StaffPageController {

    @Autowired
    private StaffPageService staffPageService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       Long id, Integer age,
                       String firstName, String lastName, String middleName, String gender,
                       String identification,
                       String email, String phoneNumber, String postCode, String role,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate entryStartDate,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate entryEndDate,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate contractStartStartDate,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate contractStartEndDate,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate contractEndStartDate,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate contractEndEndDate,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate lastUpdateTimeStart,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate lastUpdateTimeEnd,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfBirthStart,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfBirthEnd){

        log.info("Page querying with parameter: with page: {} and pageSize: {}, id: {}, age: {}, gender: {}, " +
                "email: {}, firstname: {}, lastname: {}, middle name: {}, phone number: {}, postcode: {}, " +
                "role: {}, entryDate between {} and {}, contract start date between {} and {}, contract end date between {} and {} "+
                "last update between {} and {}, date of birth between {} and {}",
                page, pageSize, id, age, gender, email, firstName, lastName, middleName, phoneNumber, postCode,
                role, entryStartDate, entryEndDate, contractStartStartDate, contractStartEndDate, contractEndStartDate, contractEndEndDate,
                lastUpdateTimeStart, lastUpdateTimeEnd, dateOfBirthStart, dateOfBirthEnd);

        return Result.success(staffPageService.page(page, pageSize, id, age, firstName, lastName, middleName, gender, identification,
                email, phoneNumber, postCode, role, entryStartDate, entryEndDate, contractStartStartDate, contractStartEndDate, contractEndStartDate, contractEndEndDate,
                lastUpdateTimeStart, lastUpdateTimeEnd, dateOfBirthStart, dateOfBirthEnd));
    }

    @GetMapping("/{ids}")
    public Result getById(@PathVariable Long ids){
        log.info("Querying staff by id: {}", ids);
        Staff staff1 = staffPageService.getById(ids);
        return Result.success(staff1);
    }

    @PostMapping("/save")
    public Result save(@RequestBody Staff staff){
        log.info("Adding dog :{}", staff);
        staffPageService.save(staff);
        return Result.success();

    }

    @PutMapping("/edit")
    public Result edit(@RequestBody Staff staff){
        log.info("Editing dog: {}", staff);
        staffPageService.edit(staff);
        return Result.success();
    }

    @DeleteMapping("delete/{ids}")
    public Result delete(@PathVariable List<Long> ids){
        log.info("Batch removing with id: {}", ids);
        staffPageService.delete(ids);
        return Result.success();
    }
}
