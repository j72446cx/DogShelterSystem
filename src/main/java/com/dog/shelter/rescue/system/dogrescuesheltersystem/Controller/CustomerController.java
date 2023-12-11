package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.CustomerPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Customer;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Result;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerPageService customerPageService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       Long id, Integer age, String firstName, String lastName, String email, String gender,
                       String address, String postCode, String avatar, String username, String password,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime registerDateStart,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime registerDateEnd,
                       String phoneNumber, Boolean isPotentialAdopter){

        log.info("Querying: page: {}, pageSize: {}, id: {}, age: {}, firstName: {}, lastName: {}, email:{}, gender:{}," +
                " address: {}, postCode: {}, avatar: {}, username: {}, password:{}, registerStart: {}, registerEnd: {}," +
                " phoneNumber: {}, isAdopter: {}", page, pageSize, id, age, firstName, lastName, email, gender,
                address, postCode, avatar, username, password, registerDateStart, registerDateEnd, phoneNumber, isPotentialAdopter);

        return Result.success(customerPageService.page(page, pageSize, id, age, firstName, lastName, email, gender, address, postCode, avatar, username, password,
                registerDateStart, registerDateEnd, phoneNumber, isPotentialAdopter));

    }

    @GetMapping("/{ids}")
    public Result getById(@PathVariable Long ids){
        log.info("Querying customer by id:{} ", ids);
        Customer customer =  customerPageService.getById(ids);
        return Result.success(customer);

    }

    @PostMapping("/save")
    public Result save(@RequestBody Customer customer){
        log.info("Adding customer: {}", customer.toString());
        customerPageService.save(customer);
        return Result.success();
    }

    @DeleteMapping("delete/{ids}")
    public Result delete(@PathVariable List<Long> ids){
        log.info("Deleting customer with id: {}", ids);
        customerPageService.delete(ids);
        return Result.success();
    }

    @PutMapping("/edit")
    public Result edit(@RequestBody Customer customer){
        log.info("Editing customer: {} ", customer);
        customerPageService.edit(customer);
        return Result.success();
    }
}
