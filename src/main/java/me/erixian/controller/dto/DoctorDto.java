package me.erixian.controller.dto;

import jakarta.persistence.Entity;
import me.erixian.domain.model.Doctor;

public class DoctorDto {
    private Long id;
    private String crm;
    private String name;

    public DoctorDto() {
    }

    public DoctorDto(Doctor model) {
        this.id = model.getId();
        this.crm = model.getCrm();
        this.name = model.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
