package me.erixian.service;

import me.erixian.controller.dto.MedicalShiftRequestDto;
import me.erixian.domain.model.MedicalShift;

import java.util.List;

public interface MedicalShiftService {
    MedicalShift findById(Long id);
    MedicalShift create(MedicalShiftRequestDto medicalShift);
    List<MedicalShift> findShiftsByDoctorId(Long doctorId);
}
