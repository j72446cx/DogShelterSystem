package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.Impl;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.PotentialAdopterRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.CustomerPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.PotentialAdopterService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.*;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Beans.ApplicationFormBean;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.utils.AliOSSUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class PotentialAdopterServiceImpl implements PotentialAdopterService {

    @Autowired
    private PotentialAdopterRepository potentialAdopterRepository;

    @Autowired
    private CustomerPageService customerPageService;

    @Autowired
    private PdfGenerator pdfGenerator;

    @Autowired
    private AliOSSUtils aliOSSUtils;

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
    public List<ApplicationForm> getFormByStatus(String status) {
        return potentialAdopterRepository.getFormByStatus(status);
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
    public void postForm(ApplicationForm applicationForm) throws FileNotFoundException {
        applicationForm.setCreated_date(LocalDateTime.now());

        List<ApplicationForm> applicationFormList = getFormByDog(applicationForm.getDog_id());
        applicationForm.setHaveCompetitor(applicationFormList != null);

        assert applicationFormList != null;
        if (!applicationFormList.isEmpty()){
            for (ApplicationForm app: applicationFormList
            ) {
                app.setHaveCompetitor(true);
                potentialAdopterRepository.editForm(app);
            }
        }
        else{
            applicationForm.setHaveCompetitor(false);
        }

        String pdfURL = generateApplicationFormPdfForAdopter(applicationForm.getAdopter_id());
        applicationForm.setPdfURL(pdfURL);
        log.info("PDF url is: {}", pdfURL);

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

    @Override
    public String generateApplicationFormPdfForAdopter(Long adopterId) throws FileNotFoundException {
        ApplicationFormBean applicationFormBean = getFormByAdopter(1, 10, adopterId);
        PotentialAdopter potentialAdopter = getById(adopterId);
        Customer customer = customerPageService.getById(adopterId);

        if (applicationFormBean != null && applicationFormBean.getRows() != null && !applicationFormBean.getRows().isEmpty()){
            Object firstRow = applicationFormBean.getRows().get(0);
            if (firstRow instanceof ApplicationForm){
                ApplicationForm applicationForm = (ApplicationForm) firstRow;
                Map<String, Object> formData = new HashMap<>();
                formData.put("id", applicationForm.getId());
                formData.put("adopter_id", applicationForm.getAdopter_id());
                formData.put("dog_id", applicationForm.getDog_id());
                formData.put("reason", applicationForm.getReason());
                formData.put("interview_date", applicationForm.getInterview_date());
                formData.put("created_date", applicationForm.getCreated_date().toString());

                byte[] pdfContent =  pdfGenerator.generatePdf(formData, potentialAdopter, customer);

                String originalFileName = "ApplicationForm_" + adopterId + ".pdf";

                String url = aliOSSUtils.upload(pdfContent, originalFileName);



                return url;



            }
        }

        return null;

    }

    @Override
    public List<ApplicationForm> getFormByDog(Long dog_id) {
        return potentialAdopterRepository.getFormByDog(dog_id);
    }
}
