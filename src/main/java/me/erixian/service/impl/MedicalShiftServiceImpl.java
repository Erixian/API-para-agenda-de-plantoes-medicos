package me.erixian.service.impl;

import me.erixian.controller.dto.MedicalShiftRequestDto;
import me.erixian.domain.model.Doctor;
import me.erixian.domain.model.Hospital;
import me.erixian.domain.model.MedicalShift;
import me.erixian.domain.repository.DoctorRepository;
import me.erixian.domain.repository.HospitalRepository;
import me.erixian.domain.repository.MedicalShiftRepository;
import me.erixian.service.MedicalShiftService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class MedicalShiftServiceImpl implements MedicalShiftService {

    private final MedicalShiftRepository medicalShiftRepository;
    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;

    public MedicalShiftServiceImpl(MedicalShiftRepository medicalShiftRepository
                                   ,DoctorRepository doctorRepository
                                   ,HospitalRepository hospitalRepository) {
        this.medicalShiftRepository = medicalShiftRepository;
        this.doctorRepository = doctorRepository;
        this.hospitalRepository = hospitalRepository;
    }
    @Override
    public MedicalShift findById(Long id) {
        return medicalShiftRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public MedicalShift create(MedicalShiftRequestDto requestDto) {
        // 1. Validate and fetch the Hospital
        Long hospitalId = requestDto.getHospitalId();
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new NoSuchElementException("Hospital not found with ID: " + hospitalId));

        // 2. Validate and fetch the list of Doctors
        List<Long> doctorIds = requestDto.getDoctorIds();
        List<Doctor> doctors = doctorRepository.findAllById(doctorIds);
        if (doctors.size() != doctorIds.size()) {
            throw new IllegalArgumentException("One or more doctor IDs are invalid.");
        }

        // 3. Create and populate the MedicalShift entity
        MedicalShift medicalShift = new MedicalShift();
        medicalShift.setStartTime(requestDto.getStartTime());
        medicalShift.setEndTime(requestDto.getEndTime());
        medicalShift.setHospital(hospital);
        medicalShift.setDoctorList(doctors);

        // 4. Save and return the entity
        return medicalShiftRepository.save(medicalShift);
    }

    @Override
    public List<MedicalShift> findShiftsByDoctorId(Long doctorId) {
        // First, check if the doctor actually exists. This is a good practice.
        if (!doctorRepository.existsById(doctorId)) {
            throw new NoSuchElementException("Doctor not found with ID: " + doctorId);
        }
        return medicalShiftRepository.findByDoctorList_Id(doctorId);
    }
}
