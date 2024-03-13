package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPageBean {

    private Long total;
    private List rows;


}
