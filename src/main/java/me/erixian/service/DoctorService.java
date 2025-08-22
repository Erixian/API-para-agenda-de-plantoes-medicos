package me.erixian.service;

import me.erixian.domain.model.Doctor;

public interface DoctorService {

    Doctor findById(Long id);

    Doctor create(Doctor doctorToCreate);
}
