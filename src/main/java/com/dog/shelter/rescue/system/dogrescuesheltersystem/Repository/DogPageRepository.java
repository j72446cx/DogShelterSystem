package com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface DogPageRepository {


    List<Dog> list(Integer age, String gender,
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

}
