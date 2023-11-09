package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.DogPageBean;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Staff;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.StaffPageBean;

import java.time.LocalDate;
import java.util.List;

public interface StaffPageService {

    void save(Staff staff);

    StaffPageBean page(Integer page, Integer pageSize,
                       Long id, Integer age,
                       String firstName, String lastName, String middleName, String gender,
                       String identification,
                       String email, String phoneNumber, String postCode, String role,
                       LocalDate entryStartDate, LocalDate entryEndDate,
                       LocalDate contractStartStartDate, LocalDate contractStartEndDate,
                       LocalDate contractEndStartDate, LocalDate contractEndEndDate,
                       LocalDate lastUpdateTimeStart, LocalDate lastUpdateTimeEnd,
                       LocalDate dateOfBirthStart, LocalDate dateOfBirthEnd);

    void delete(List<Long> ids);

    void edit(Staff staff);

    Staff getById(Long id);

    Staff login(Staff staff);
}
