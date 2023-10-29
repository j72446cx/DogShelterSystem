package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.Impl;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.DogPageRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.DogPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.DogService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.DogPageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogPageServiceImpl implements DogPageService {

    @Autowired
    private DogPageRepository dogPageRepository;

//    @Override
//    public DogPageBean page(Integer page, Integer pageSize){
//
//        // Get count of data
//        Long count = dogPageRepository.count();
//
//        // Page Query result
//        List<Dog> dogList = dogPageRepository.page((page - 1) * pageSize, pageSize);
//
//        // Encapsulate PageBean
//        return new DogPageBean(count, dogList);
//
//
//
//
//
//
//    }
    @Override
    public DogPageBean page(Integer page, Integer pageSize){

        PageHelper.startPage(page, pageSize);

        List<Dog> dogList = dogPageRepository.list();
        Page<Dog> dogPage = (Page<Dog>) dogList;

        // Encapsulate PageBean
        return new DogPageBean(dogPage.getTotal(), dogPage.getResult());

    }
}
