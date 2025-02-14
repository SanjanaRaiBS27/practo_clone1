package com.practo.clone.repository;

import com.practo.clone.model.PracticeSpecialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PracticeSpecializationRepository extends JpaRepository<PracticeSpecialization, Integer> {
    List<PracticeSpecialization> findByPracticeId(int practiceId);
    List<PracticeSpecialization> findBySpecializationId(int specializationId);
}