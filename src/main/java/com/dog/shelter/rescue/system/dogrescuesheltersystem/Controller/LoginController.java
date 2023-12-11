package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.CustomerPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.StaffPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Customer;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Result;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Staff;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private StaffPageService staffPageService;

    @Autowired
    private CustomerPageService customerPageService;

    @PostMapping("/login")
    public Result login(@RequestBody Staff staff){
        log.info("Staff login: {}", staff);
        Staff staff1 = staffPageService.login(staff);

        // login successful
        if (staff1 != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", staff1.getId());
            claims.put("firstName", staff1.getFirstName());
            claims.put("lastName", staff1.getLastName());
            claims.put("username", staff1.getUsername());
            claims.put("ms_role", "staff");

            String jwt = JwtUtils.generateJwt(claims);

            return Result.success(jwt);
        }

        // handle unsuccessful

        return Result.error("Incorrect username or password");
    }

    @PostMapping("/loginCustomer")
    public Result loginCustomer(@RequestBody Customer customer){

        Customer customer1 =  customerPageService.login(customer);
        log.info("Customer login: {}", customer1);

        if (customer1 != null){
            Map<String, Object> claims2 = new HashMap<>();
            claims2.put("id", customer1.getId());
            claims2.put("firstName",customer1.getFirstName());
            claims2.put("lastName", customer1.getLastName());
            claims2.put("username", customer1.getUsername());
            claims2.put("email",customer1.getEmail());
            claims2.put("isPotentialAdopter", customer1.getPotentialAdopter());
            claims2.put("ms_role", "user");

            String jwt = JwtUtils.generateJwt(claims2);
            return Result.success(jwt);
        }
        return Result.error("Incorrect username or password");
    }

}
