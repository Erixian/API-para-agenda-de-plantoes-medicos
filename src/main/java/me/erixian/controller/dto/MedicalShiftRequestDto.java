package me.erixian.controller.dto;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.List;


public class MedicalShiftRequestDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long hospitalId;
    private List<Long> doctorIds;

    public MedicalShiftRequestDto() {
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public List<Long> getDoctorIds() {
        return doctorIds;
    }

    public void setDoctorIds(List<Long> doctorIds) {
        this.doctorIds = doctorIds;
    }
}
