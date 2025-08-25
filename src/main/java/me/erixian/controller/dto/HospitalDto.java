package me.erixian.controller.dto;

import jakarta.persistence.Entity;
import me.erixian.domain.model.Hospital;


public class HospitalDto {
    private Long id;
    private String name;
    private String address;
    // NOTE: No medicalShiftList here! This breaks the circle.


    public HospitalDto() {
    }

    public HospitalDto(Hospital model) {
        this.id = model.getId();
        this.name = model.getName();
        this.address = model.getAddress();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
