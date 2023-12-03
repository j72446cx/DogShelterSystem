package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Customer;

import java.util.List;

public interface CustomerPageService {
    void save(Customer customer);

    Customer getById(Long ids);

    void delete(List<Long> ids);

    void edit(Customer customer);
}
