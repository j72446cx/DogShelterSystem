package com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Staff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface StaffPageRepository {

    @Insert("INSERT INTO Staff (age, firstName, lastName, middleName, email, phoneNumber, address, postCode, role, dateOfBirth, gender, entryDate, salary, emergency_Contact, avatar, contractStartDate, contractEndDate, username, password, contractImg, identityPhoto, identification, lastUpdateTime) " +
            "VALUES (#{age}, #{firstName}, #{lastName}, #{middleName}, #{email}, #{phoneNumber}, #{address}, #{postCode}, #{role}, #{dateOfBirth}, #{gender}, #{entryDate}, #{salary}, #{emergency_Contact}, #{avatar}, #{contractStartDate}, #{contractEndDate}, #{username}, #{password}, #{contractImg}, #{identityPhoto}, #{identification}, #{lastUpdateTime})")
    void insert(Staff staff);

    List<Staff> list(Long id, Integer age,
                     String firstName, String lastName, String middleName, String gender,
                     String identification,
                     String email, String phoneNumber, String postCode, String role,
                     LocalDate entryStartDate, LocalDate entryEndDate,
                     LocalDate contractStartStartDate, LocalDate contractStartEndDate,
                     LocalDate contractEndStartDate, LocalDate contractEndEndDate,
                     LocalDate lastUpdateTimeStart, LocalDate lastUpdateTimeEnd,
                     LocalDate dateOfBirthStart, LocalDate dateOfBirthEnd, String username);

    void delete(List<Long> ids);

    void edit(Staff staff);

    @Select("select * from Staff where id = #{id}")
    Staff getById(Long id);

    @Select("select * from Staff where username = #{username} and password = #{password}")
    Staff getByUsernameAndPassword(Staff staff);

    @Select("SELECT d.* FROM Dog d INNER JOIN Staff_Dog sd ON d.id = sd.dog_id WHERE sd.staff_id = #{id}")
    List<Dog> staffGetDog(Long id);
}
