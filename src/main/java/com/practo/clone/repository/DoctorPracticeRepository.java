package com.practo.clone.repository;


import com.practo.clone.model.DoctorPractice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorPracticeRepository extends JpaRepository<DoctorPractice, Integer> {
    List<DoctorPractice> findByDoctorId(int doctorId);
    //List<DoctorPractice> findByPracticeId(int practiceId);
   // List<DoctorPractice> findByNameContainingIgnoreCase(String name);



    List<DoctorPractice> findAllByPracticeId(int practiceId);




}