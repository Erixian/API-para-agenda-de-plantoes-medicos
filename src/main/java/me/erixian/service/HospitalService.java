package me.erixian.service;

import me.erixian.controller.dto.HospitalDto;
import me.erixian.domain.model.Hospital;

public interface HospitalService {
    Hospital findById(Long id);
    Hospital create(HospitalDto hospitalToCreate);
}
