package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Customer;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Beans.CustomerPageBean;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomerPageService {
    void save(Customer customer);

    Customer getById(Long ids);

    void delete(List<Long> ids);

    void edit(Customer customer);

    Customer login(Customer customer);

    void isPotentialAdopter(Long id);

    CustomerPageBean page(Integer page, Integer pageSize, Long id, Integer age, String firstName, String lastName, String email, String gender, String address, String postCode, String avatar, String username, String password, LocalDateTime registerDateStart, LocalDateTime registerDateEnd, String phoneNumber, Boolean isPotentialAdopter);
}
