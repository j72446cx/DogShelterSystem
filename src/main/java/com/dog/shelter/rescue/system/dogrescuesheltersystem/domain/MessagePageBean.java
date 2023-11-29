package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessagePageBean {

    private long total;
    private List rows;
}
