package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.Impl;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.PotentialAdopterRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.CustomerPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.PotentialAdopterService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PotentialAdopterServiceImpl implements PotentialAdopterService {

    @Autowired
    private PotentialAdopterRepository potentialAdopterRepository;

    @Autowired
    private CustomerPageService customerPageService;

    @Override
    public void save(PotentialAdopter potentialAdopter) {
        potentialAdopterRepository.save(potentialAdopter);
        customerPageService.isPotentialAdopter(potentialAdopter.getId());
    }

    @Override
    public PotentialAdopter getById(Long ids) {

        return potentialAdopterRepository.getById(ids);
    }

    @Override
    public ApplicationFormBean getFormByAdopter(Integer page, Integer pageSize, Long adopter_id) {
        PageHelper.startPage(page, pageSize);
        List<ApplicationForm> applicationFormList = potentialAdopterRepository.getFormByAdopter(adopter_id);
        Page<ApplicationForm> applicationForms = (Page<ApplicationForm>) applicationFormList;
        return new ApplicationFormBean(applicationForms.getTotal(), applicationForms.getResult());
    }

    @Override
    public void edit(PotentialAdopter potentialAdopter) {
        potentialAdopterRepository.edit(potentialAdopter);
    }

    @Override
    public void delete(List<Long> ids) {
        potentialAdopterRepository.delete(ids);
    }


    @Override
    public void postForm(ApplicationForm applicationForm) {
        applicationForm.setCreated_date(LocalDateTime.now());
        potentialAdopterRepository.postForm(applicationForm);
    }

    @Override
    public ApplicationForm getForm(Long ids) {
        return potentialAdopterRepository.getForm(ids);
    }

    @Override
    public void editForm(ApplicationForm applicationForm) {
        potentialAdopterRepository.editForm(applicationForm);
    }

    @Override
    public void deleteForm(List<Long> ids) {
        potentialAdopterRepository.deleteForm(ids);
    }
}
