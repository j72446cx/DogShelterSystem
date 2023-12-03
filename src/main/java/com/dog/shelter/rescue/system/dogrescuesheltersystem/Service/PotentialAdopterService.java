package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.PotentialAdopter;

import java.util.List;

public interface PotentialAdopterService {
    void save(PotentialAdopter potentialAdopter);

    PotentialAdopter getById(Long ids);

    void edit(PotentialAdopter potentialAdopter);

    void delete(List<Long> ids);
}
