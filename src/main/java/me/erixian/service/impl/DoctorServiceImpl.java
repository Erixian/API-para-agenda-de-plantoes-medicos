package me.erixian.service.impl;

import me.erixian.domain.model.Doctor;
import me.erixian.domain.repository.DoctorRepository;
import me.erixian.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Doctor create(Doctor doctorToCreate) {
        if(doctorRepository.existsByCrm(doctorToCreate.getCrm())){
            throw new IllegalArgumentException("This CRM already exists");
        }
        return doctorRepository.save(doctorToCreate);
    }
}
