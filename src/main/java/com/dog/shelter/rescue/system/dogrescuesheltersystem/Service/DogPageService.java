package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.DogPageBean;
import org.apache.ibatis.annotations.Select;

public interface DogPageService {

    DogPageBean page(Integer page, Integer pageSize);
}
