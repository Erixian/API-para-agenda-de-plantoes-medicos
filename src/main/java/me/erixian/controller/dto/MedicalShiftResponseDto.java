package me.erixian.controller.dto;

import jakarta.persistence.Entity;
import me.erixian.domain.model.MedicalShift;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


public class MedicalShiftResponseDto {
    private Long id;
    private LocalDateTime starTime;
    private LocalDateTime endTime;
    private HospitalDto hospitalDto;
    private List<DoctorDto> doctorList;

    public MedicalShiftResponseDto() {
    }

    public MedicalShiftResponseDto(MedicalShift model) {
        this.id = model.getId();
        this.starTime = model.getStartTime();
        this.endTime = model.getEndTime();
        this.hospitalDto = new HospitalDto(model.getHospital());
        this.doctorList = model.getDoctorList().stream().map(DoctorDto::new).collect(Collectors.toList());


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStarTime() {
        return starTime;
    }

    public void setStarTime(LocalDateTime starTime) {
        this.starTime = starTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public HospitalDto getHospitalDto() {
        return hospitalDto;
    }

    public void setHospitalDto(HospitalDto hospitalDto) {
        this.hospitalDto = hospitalDto;
    }

    public List<DoctorDto> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<DoctorDto> doctorList) {
        this.doctorList = doctorList;
    }
}
