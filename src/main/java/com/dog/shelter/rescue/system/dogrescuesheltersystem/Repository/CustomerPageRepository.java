package com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
