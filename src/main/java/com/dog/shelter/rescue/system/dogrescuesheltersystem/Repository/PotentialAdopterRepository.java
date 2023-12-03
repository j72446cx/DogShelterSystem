package com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.PotentialAdopter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PotentialAdopterRepository {

    @Insert("INSERT INTO PotentialAdopter (id, householdMembers, children, otherPets, housingType, housingStability, landlordConsent, workStudySchedule, dailyActivities, incomeLevel, petInsurance, previousPetOwnership, petCareKnowledge, petPreference, emergencyPlan, referencePerson, agreementCompliance, postAdoptionSupportCommitment, landlordContact, adoptionPurpose) " +
            "VALUES (#{id}, #{householdMembers}, #{children}, #{otherPets}, #{housingType}, #{housingStability}, #{landlordConsent}, #{workStudySchedule}, #{dailyActivities}, #{incomeLevel}, #{petInsurance}, #{previousPetOwnership}, #{petCareKnowledge}, #{petPreference}, #{emergencyPlan}, #{referencePerson}, #{agreementCompliance}, #{postAdoptionSupportCommitment}, #{landlordContact}, #{adoptionPurpose})")
    void save(PotentialAdopter potentialAdopter);

    @Select("select * from PotentialAdopter where id = #{id}")
    PotentialAdopter getById(Long ids);

    void edit(PotentialAdopter potentialAdopter);

    void delete(List<Long> ids);
}
