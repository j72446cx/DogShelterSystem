package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.Impl;


import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.CustomerPageRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.CustomerPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Customer;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.CustomerPageBean;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.DogPageBean;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Request.MedicationRequest;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerPageServiceImpl implements CustomerPageService {

    @Autowired
    private CustomerPageRepository customerPageRepository;

    @Override
    public void isPotentialAdopter(Long id) {
        customerPageRepository.isPotentialAdopter(id);
    }

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

    @Override
    public Customer login(Customer customer) {
        return customerPageRepository.login(customer);
    }

    @Override
    public CustomerPageBean page(Integer page, Integer pageSize, Long id, Integer age, String firstName, String lastName, String email, String gender, String address, String postCode, String avatar, String username, String password, LocalDateTime registerDateStart, LocalDateTime registerDateEnd, String phoneNumber, Boolean isPotentialAdopter) {
        PageHelper.startPage(page, pageSize);
        List<Customer> listCustomer = customerPageRepository.list(id, age, firstName, lastName, email, gender, address, postCode, avatar, username, password,registerDateStart,registerDateEnd, phoneNumber, isPotentialAdopter);
        Page<Customer> pageCustomer = (Page<Customer>) listCustomer;
        return new CustomerPageBean(pageCustomer.getTotal(), pageCustomer.getResult());
    }
}
