package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.Impl;


import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.StaffPageRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.StaffPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.DogPageBean;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Staff;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.StaffPageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StaffPageServiceImpl implements StaffPageService{

    @Autowired
    private StaffPageRepository staffPageRepository;

    @Override
    public void save(Staff staff) {
        staff.setLastUpdateTime(LocalDateTime.now());
        staffPageRepository.insert(staff);
    }

    @Override
    public List<Dog> staffGetDog(Long id){
        return staffPageRepository.staffGetDog(id);
    }

    @Override
    public StaffPageBean page(Integer page, Integer pageSize,
                              Long id, Integer age,
                              String firstName, String lastName, String middleName, String gender,
                              String identification,
                              String email, String phoneNumber, String postCode, String role,
                              LocalDate entryStartDate, LocalDate entryEndDate,
                              LocalDate contractStartStartDate, LocalDate contractStartEndDate,
                              LocalDate contractEndStartDate, LocalDate contractEndEndDate,
                              LocalDate lastUpdateTimeStart, LocalDate lastUpdateTimeEnd,
                              LocalDate dateOfBirthStart, LocalDate dateOfBirthEnd, String username){

        PageHelper.startPage(page, pageSize);
        List<Staff> staffList =  staffPageRepository.list(id, age, firstName, lastName, middleName, gender,
                identification, email, phoneNumber, postCode, role,
                entryStartDate, entryEndDate,
                contractStartStartDate, contractStartEndDate,
                contractEndStartDate, contractEndEndDate,
                lastUpdateTimeStart, lastUpdateTimeEnd, dateOfBirthStart, dateOfBirthEnd, username);

        Page<Staff> staffPage = (Page<Staff>) staffList;

        return new StaffPageBean(staffPage.getTotal(), staffPage.getResult());
    }

    @Override
    public void delete(List<Long> ids) {
        staffPageRepository.delete(ids);
    }

    @Override
    public void edit(Staff staff){
        staff.setLastUpdateTime(LocalDateTime.now());
        staffPageRepository.edit(staff);
    }

    @Override
    public Staff getById(Long id){
        return staffPageRepository.getById(id);
    }

    @Override
    public Staff login(Staff staff){
        return staffPageRepository.getByUsernameAndPassword(staff);
    }

}
