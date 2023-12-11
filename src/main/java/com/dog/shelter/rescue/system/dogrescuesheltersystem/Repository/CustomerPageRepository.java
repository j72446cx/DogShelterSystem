package com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface CustomerPageRepository {

    @Insert("INSERT INTO Customer (age, firstName, lastName, middleName, email, phoneNumber, address, postCode, gender, registerDate, avatar, username, password) " +
            "VALUES (#{age}, #{firstName}, #{lastName}, #{middleName}, #{email}, #{phoneNumber}, #{address}, #{postCode}, #{gender}, #{registerDate}, #{avatar}, #{username}, #{password})")
    void save(Customer customer);

    @Select("select * from Customer where id = #{id}")
    Customer getById(Long ids);

    void delete(List<Long> ids);

    void edit(Customer customer);

    @Select("select * from Customer where username = #{username} and password = #{password}")
    Customer login(Customer customer);

    @Update("update Customer set isPotentialAdopter=true where id = #{id}")
    void isPotentialAdopter(Long id);

    List<Customer> list(Long id, Integer age, String firstName, String lastName, String email, String gender, String address, String postCode, String avatar, String username, String password, LocalDateTime registerDateStart, LocalDateTime registerDateEnd, String phoneNumber, Boolean isPotentialAdopter);
}
