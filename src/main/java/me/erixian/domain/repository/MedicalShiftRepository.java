package me.erixian.domain.repository;

import me.erixian.domain.model.MedicalShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalShiftRepository extends JpaRepository<MedicalShift, Long> {
    List<MedicalShift> findByDoctorList_Id(Long doctorId);
}
