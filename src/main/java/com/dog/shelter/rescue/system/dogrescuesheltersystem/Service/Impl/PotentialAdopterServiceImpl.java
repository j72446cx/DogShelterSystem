package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.Impl;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.PotentialAdopterRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.PotentialAdopterService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.ApplicationForm;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.PotentialAdopter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PotentialAdopterServiceImpl implements PotentialAdopterService {

    @Autowired
    private PotentialAdopterRepository potentialAdopterRepository;

    @Override
    public void save(PotentialAdopter potentialAdopter) {
        potentialAdopterRepository.save(potentialAdopter);
    }

    @Override
    public PotentialAdopter getById(Long ids) {

        return potentialAdopterRepository.getById(ids);
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
