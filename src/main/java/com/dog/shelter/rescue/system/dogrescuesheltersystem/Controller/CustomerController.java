package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.CustomerPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Customer;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerPageService customerPageService;

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
