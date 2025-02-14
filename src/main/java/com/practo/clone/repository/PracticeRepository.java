package com.practo.clone.repository;

import com.practo.clone.model.Practice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PracticeRepository extends JpaRepository<Practice, Integer> {
    List<Practice> findByNameContainingIgnoreCase(String name);
    public Practice findByName(String name);


    List<Practice> findAllByName(String practiceName);
}