package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.Impl;


import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.CustomerPageRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.CustomerPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerPageServiceImpl implements CustomerPageService {

    @Autowired
    private CustomerPageRepository customerPageRepository;

    @Override
    public void save(Customer customer) {
        customerPageRepository.save(customer);
    }

    @Override
    public Customer getById(Long ids) {
        return customerPageRepository.getById(ids);
    }

    @Override
    public void delete(List<Long> ids) {
        customerPageRepository.delete(ids);
    }

    @Override
    public void edit(Customer customer) {
        customerPageRepository.edit(customer);
    }
}
