package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.ApplicationForm;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Beans.ApplicationFormBean;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.PotentialAdopter;

import java.io.FileNotFoundException;
import java.util.List;

public interface PotentialAdopterService {
    void save(PotentialAdopter potentialAdopter);

    PotentialAdopter getById(Long ids);

    void edit(PotentialAdopter potentialAdopter);

    void delete(List<Long> ids);

    void postForm(ApplicationForm applicationForm) throws FileNotFoundException;

    ApplicationForm getForm(Long ids);

    void editForm(ApplicationForm applicationForm);

    void deleteForm(List<Long> ids);

    ApplicationFormBean getFormByAdopter(Integer page, Integer pageSize, Long adopter_id);

    String generateApplicationFormPdfForAdopter(Long adopterId) throws FileNotFoundException;

    List<ApplicationForm> getFormByStatus(String status);

    List<ApplicationForm> getFormByDog(Long dog_id);
}
