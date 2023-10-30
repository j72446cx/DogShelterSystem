package com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Mapper
public interface DogRepository {

    @Select("select * from Dog")
    List<Dog> findAll();

    @Select("SELECT * FROM Dog WHERE id = #{id}")
    Dog findById(@Param("id") long id);

    @Insert("INSERT INTO Dog (name, age, imgURL, species, AdoptStatus, MedicalHistory, intro, gender, EntryDate, AdoptedDate, LastVaccineDate, LastUpdateTime) VALUES (#{name}, #{age}, #{imgURL}, #{species}, #{AdoptStatus}, #{MedicalHistory}, #{intro}, #{gender}, #{EntryDate}, #{AdoptedDate}, #{LastVaccineDate}, #{LastUpdateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Boolean save(Dog dog);

    @Select("SELECT * FROM Dog WHERE id = #{id}")
    Boolean existsById(long id);

    @Delete("DELETE FROM Dog WHERE id = #{id}")
    Boolean deleteById(long id);

    @Select("SELECT * FROM Dog WHERE species = #{species}")
    List<Dog> findDogsBySpecies(String species);

    @Select("SELECT intro FROM Dog WHERE id = #{id}")
    String getIntroById(long id);

    @Select("SELECT species FROM Dog WHERE id = #{id}")
    String getSpeciesById(long id);

    @Select("SELECT name FROM Dog WHERE id = #{id}")
    String getNameById(long id);

    @Select("SELECT imgURL FROM Dog WHERE id = #{id}")
    String getURLById(long id);

    @Select("SELECT AdoptStatus FROM Dog WHERE id = #{id}")
    String getStatusById(long id);

    @Select("SELECT MedicalHistory FROM Dog WHERE id = #{id}")
    String getMedicalById(long id);

    @Select("SELECT age FROM Dog WHERE id = #{id}")
    int getAgeById(long id);

    @Update("UPDATE Dog SET " +
            "name = #{dog.name}, " +
            "age = #{dog.age}, " +
            "imgURL = #{dog.imgURL}, " +
            "species = #{dog.species}, " +
            "AdoptStatus = #{dog.AdoptStatus}, " +
            "MedicalHistory = #{dog.MedicalHistory}, " +
            "intro = #{dog.intro}, " +
            "gender = #{dog.gender} " +
            "EntryDate = #{dog.EntryDate}" +
            "AdoptedDate = #{dog.AdoptedDate}" +
            "LastVaccineDate = #{dog.LastVaccineDate}" +
            "LastUpdateTime = #{dog.LastUpdateTime}"+
            "WHERE id = #{id}")
    boolean updatingDog(@Param("id") long id, @Param("dog") Dog dog);


    @Delete("DELETE FROM Dog")
    Boolean cleaning_database();

}
