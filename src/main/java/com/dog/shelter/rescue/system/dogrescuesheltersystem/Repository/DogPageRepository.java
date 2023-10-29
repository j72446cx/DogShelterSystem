package com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface DogPageRepository {

    /*
    * Get the count of data
    * */

//    @Select("select count(*) from Dog")
//    public Long count();
//
//
//    /*
//    * Paging query
//    * */
//    @Select("select * from Dog limit #{start}, #{pageSize}")
//    public List<Dog> page(Integer start, Integer pageSize);

//    @Select("select * from Dog")
    List<Dog> list(Integer age, String gender,
                          LocalDate entryStartDate,
                          LocalDate entryEndDate,
                          LocalDate adoptedStartDate,
                          LocalDate adoptedEndDate,
                          LocalDate vaccineStartDate,
                          LocalDate vaccineEndDate
                   );

    void delete(List<Long> ids);

}
