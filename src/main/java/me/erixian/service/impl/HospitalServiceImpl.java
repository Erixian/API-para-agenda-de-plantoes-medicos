package me.erixian.service.impl;

import me.erixian.controller.dto.HospitalDto;
import me.erixian.domain.model.Hospital;
import me.erixian.domain.repository.HospitalRepository;
import me.erixian.service.HospitalService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalServiceImpl(HospitalRepository hospitalRepository){
        this.hospitalRepository = hospitalRepository;
    }
    @Override
    public Hospital findById(Long id) {
        return hospitalRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Hospital create(HospitalDto hospitalToCreate) {
        if(hospitalRepository.existsByName(hospitalToCreate.getName())){
            throw new IllegalArgumentException("This Hospital name already exists");
        }

        Hospital hospitalEntity = new Hospital();
        hospitalEntity.setName(hospitalToCreate.getName());
        hospitalEntity.setAddress(hospitalToCreate.getAddress());
        return hospitalRepository.save(hospitalEntity);
    }
}
