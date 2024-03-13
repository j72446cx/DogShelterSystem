package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DogPageBean {

    private Long total; // total count of pages
    private List rows; // list for data

}
