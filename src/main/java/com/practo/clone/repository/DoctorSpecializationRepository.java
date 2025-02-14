package com.practo.clone.repository;

import com.practo.clone.model.DoctorSpecialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorSpecializationRepository extends JpaRepository<DoctorSpecialization, Integer> {
    List<DoctorSpecialization> findByDoctorId(int doctorId);
    List<DoctorSpecialization> findBySpecializationId(int specializationId);
}