package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.PotentialAdopterService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.ApplicationForm;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.PdfGenerator;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.PotentialAdopter;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/adopter")

public class PotentialAdopterController {

    @Autowired
    private PotentialAdopterService potentialAdopterService;

    @Autowired
    private PdfGenerator pdfGenerator;

    @PostMapping("/application/postForm")
    public Result postForm(@RequestBody ApplicationForm applicationForm) throws FileNotFoundException {
        log.info("Application form posting: {} ", applicationForm.toString());
        potentialAdopterService.postForm(applicationForm);
        return Result.success();
    }

    @GetMapping("/application/{ids}")
    public Result getForm(@PathVariable Long ids){
        log.info("Querying form with id: {}", ids);
        ApplicationForm applicationForm = potentialAdopterService.getForm(ids);
        return Result.success(applicationForm);
    }

    @GetMapping("application/byDog/{dog_id}")
    public Result getFormByDog(@PathVariable Long dog_id){
        log.info("Querying form with dog_id: {}", dog_id);
        List<ApplicationForm> applicationForms = potentialAdopterService.getFormByDog(dog_id);
        return Result.success(applicationForms);
    }

    @GetMapping("/application/adopter")
    public Result getFormByAdopter(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            Long adopter_id){
        log.info("Querying form by adopter id: {}, page:{}, pageSize: {}", adopter_id, page, pageSize);
        return Result.success(potentialAdopterService.getFormByAdopter(page, pageSize, adopter_id));
    }

    @GetMapping("application/status")
    public Result getFormByStatus(String status){
        log.info("Querying form by status: {}", status);
        return Result.success(potentialAdopterService.getFormByStatus(status));
    }

    @PutMapping("/application/editForm")
    public Result editForm(@RequestBody ApplicationForm applicationForm){
        log.info("Editing application form: {}", applicationForm);
        potentialAdopterService.editForm(applicationForm);
        return Result.success();
    }

    @DeleteMapping("/application/deleteForm/{ids}")
    public Result deleteForm(@PathVariable List<Long> ids){
        log.info("Deleting form with id: {}", ids);
        potentialAdopterService.deleteForm(ids);
        return Result.success();
    }

    @PostMapping("/save")
    public Result save(@RequestBody PotentialAdopter potentialAdopter){
        if (potentialAdopterService.getById(potentialAdopter.getId()) != null){
            return Result.error("Potential Adopter already exists");
        }
        log.info("New potential adopter: {}", potentialAdopter.toString());
        potentialAdopterService.save(potentialAdopter);
        return Result.success();
    }

    @GetMapping("/{ids}")
    public Result getById(@PathVariable Long ids){
        log.info("Querying potential adopter with id: {}", ids);
        PotentialAdopter potentialAdopter =  potentialAdopterService.getById(ids);
        return Result.success(potentialAdopter);
    }

    @PutMapping("/edit")
    public Result edit(@RequestBody PotentialAdopter potentialAdopter){
        log.info("Editing potential adopter: {}", potentialAdopter);
        potentialAdopterService.edit(potentialAdopter);
        return Result.success();
    }

    @DeleteMapping("/delete/{ids}")
    public Result delete(@PathVariable List<Long> ids){
        log.info("Deleteing potential adopter with ids: {}", ids);
        potentialAdopterService.delete(ids);
        return Result.success();
    }

    @GetMapping("/pdf")
    public Result generatePdf(@RequestParam Long adopterId){
        try{
            String url = potentialAdopterService.generateApplicationFormPdfForAdopter(adopterId);
            return Result.success(url);
        }
        catch (FileNotFoundException e){
            return Result.error(e.toString());
        }
    }


}
