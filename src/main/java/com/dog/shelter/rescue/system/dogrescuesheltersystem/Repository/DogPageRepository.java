package com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface DogPageRepository {


    List<Dog> list(Long id, String species, String adoptStatus, Integer age, String gender,
                          LocalDate entryStartDate,
                          LocalDate entryEndDate,
                          LocalDate adoptedStartDate,
                          LocalDate adoptedEndDate,
                          LocalDate vaccineStartDate,
                          LocalDate vaccineEndDate,
                   LocalDate lastUpdateTimeStart,
                   LocalDate lastUpdateTimeEnd
                   );

    void delete(List<Long> ids);

    @Insert("INSERT INTO Dog (name, age, imgURL, species, AdoptStatus, MedicalHistory, intro, gender, EntryDate, AdoptedDate, LastVaccineDate, LastUpdateTime) VALUES (#{name}, #{age}, #{imgURL}, #{species}, #{AdoptStatus}, #{MedicalHistory}, #{intro}, #{gender}, #{EntryDate}, #{AdoptedDate}, #{LastVaccineDate}, #{LastUpdateTime})")
    void insert(Dog dog);



    void edit(Dog dog);


    @Select("select * from Dog where id = #{id}")
    Dog getById(Long id);
}
