package me.erixian.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name= "tb_hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MedicalShift> medicalShiftList;

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

    public List<MedicalShift> getMedicalShiftList() {
        return medicalShiftList;
    }

    public void setMedicalShiftList(List<MedicalShift> medicalShiftList) {
        this.medicalShiftList = medicalShiftList;
    }
}
