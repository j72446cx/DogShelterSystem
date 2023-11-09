package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.StaffPageService;
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

            String jwt = JwtUtils.generateJwt(claims);

            return Result.success(jwt);
        }

        // handle unsuccessful

        return Result.error("Incorrect username or password");


    }

}
