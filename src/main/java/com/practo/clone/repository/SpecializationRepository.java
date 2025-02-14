package com.practo.clone.repository;

import com.practo.clone.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

    // Find all specializations linked to a specific practice
    //@Query("SELECT s FROM Specialization s WHERE s.practice.id = :practiceId")
    List<Specialization> findByPracticeId(Long practiceId);

    // Find specializations by name (case-insensitive search)
//    @Query("SELECT s FROM Specialization s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :specializationName, '%'))")
    List<Specialization> findByNameContainingIgnoreCase(String specializationName);



    // Find a specialization by exact name (useful for precise searches)
    //@Query("SELECT s FROM Specialization s WHERE LOWER(s.name) = LOWER(:specializationName)")
    //Specialization findByExactName(@Param("specializationName") String specializationName);

}
