package com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.ApplicationForm;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.PotentialAdopter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PotentialAdopterRepository {

    @Insert("INSERT INTO PotentialAdopter (id, householdMembers, children, otherPets, housingType, housingStability, landlordConsent, workStudySchedule, dailyActivities, incomeLevel, petInsurance, previousPetOwnership, petCareKnowledge, petPreference, emergencyPlan, referencePerson, agreementCompliance, postAdoptionSupportCommitment, landlordContact, adoptionPurpose, living_room, garden, balcony, kitchen, family_photo, preparation) " +
            "VALUES (#{id}, #{householdMembers}, #{children}, #{otherPets}, #{housingType}, #{housingStability}, #{landlordConsent}, #{workStudySchedule}, #{dailyActivities}, #{incomeLevel}, #{petInsurance}, #{previousPetOwnership}, #{petCareKnowledge}, #{petPreference}, #{emergencyPlan}, #{referencePerson}, #{agreementCompliance}, #{postAdoptionSupportCommitment}, #{landlordContact}, #{adoptionPurpose}, #{living_room}, #{garden}, #{balcony}, #{kitchen}, #{family_photo}, #{preparation})")
    void save(PotentialAdopter potentialAdopter);

    @Select("select * from PotentialAdopter where id = #{id}")
    PotentialAdopter getById(Long ids);

    void edit(PotentialAdopter potentialAdopter);

    void delete(List<Long> ids);


    @Insert("INSERT INTO ApplicationForm (adopter_id, dog_id, interview_date, reason, status, created_date, haveCompetitor, pdfURL) " +
            "VALUES (#{adopter_id}, #{dog_id}, #{interview_date}, #{reason}, #{status}, #{created_date}, #{haveCompetitor}, #{pdfURL})")
    void postForm(ApplicationForm applicationForm);

    @Select("select * from ApplicationForm where id = #{ids}")
    ApplicationForm getForm(Long ids);

    void editForm(ApplicationForm applicationForm);

    void deleteForm(List<Long> ids);

    @Select("select * from ApplicationForm where adopter_id = #{adopter_id}")
    List<ApplicationForm> getFormByAdopter(Long adopter_id);

    @Select("select * from ApplicationForm where status = #{status}")
    List<ApplicationForm> getFormByStatus(String status);

    @Select("select * from ApplicationForm where status != 'Rejected' and dog_id = #{dog_id}")
    List<ApplicationForm> getFormByDog(Long dog_id);
}
