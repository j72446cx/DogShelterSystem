package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffPageBean {

    private long total;
    private List rows;

}
