package com.practo.clone.repository;

import com.practo.clone.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    //@Query("SELECT d FROM Doctor d WHERE LOWER(d.name) LIKE LOWER(CONCAT(:letter, '%'))")
    List<Doctor> findByNameStartingWith(@Param("doctorName") String doctorName);

    Doctor findByNameIgnoreCase(String name);

    List<Doctor> findByNameContainingIgnoreCase(String name);
    List<Doctor> findAllById(Iterable<Integer> ids);
}