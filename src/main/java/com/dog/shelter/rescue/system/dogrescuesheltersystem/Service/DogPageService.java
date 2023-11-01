package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Dog;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.DogPageBean;
import org.apache.ibatis.annotations.Select;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface DogPageService {

    DogPageBean page(Integer page, Integer pageSize,
                     Long id, String species, String adoptStatus,
                     Integer age, String gender,
                     LocalDate entryStartDate,
                     LocalDate entryEndDate,
                     LocalDate adoptedStartDate,
                     LocalDate adoptedEndDate,
                     LocalDate vaccineStartDate,
                     LocalDate vaccineEndDate,
                     LocalDate lastUpdateTimeStart,
                     LocalDate lastUpdateTimeEnd);

    void delete(List<Long> ids);

    void save(Dog dog);

    void edit(Dog dog);

    Dog getById(Long id);
}
