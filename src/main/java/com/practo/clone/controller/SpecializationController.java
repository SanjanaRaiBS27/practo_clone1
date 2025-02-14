package com.practo.clone.controller;

import com.practo.clone.dto.SpecializationDTO;
import com.practo.clone.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specializations")  // 🔹 Updated endpoint for better RESTful structure
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;

    // 🔹 Fetch all specializations
    @GetMapping
    public List<SpecializationDTO> getAllSpecializations() {
        return specializationService.getAllSpecializations();
    }

    // 🔹 Fetch a specialization by ID
    @GetMapping("/{id}")
    public SpecializationDTO getSpecializationById(@PathVariable Long id) {
        return specializationService.getSpecializationById(id);
    }

    // 🔹 Fetch doctors by specialization name (Mapping Fix)
    // http://localhost:8080/api/specializations/name/{specializationName}
    @GetMapping("/name/{specializationName}")
    public List<SpecializationDTO> getSpecializationsByName(@PathVariable String specializationName) {
        return specializationService.getSpecializationsByName(specializationName);
    }

    // 🔹 Create a new specialization
    @PostMapping
    public SpecializationDTO createSpecialization(@RequestBody SpecializationDTO specializationDTO) {
        return specializationService.createSpecialization(specializationDTO);
    }

    // 🔹 Update a specialization
    @PutMapping("/{id}")
    public SpecializationDTO updateSpecialization(@PathVariable Long id, @RequestBody SpecializationDTO specializationDTO) {
        return specializationService.updateSpecialization(id, specializationDTO);
    }

    // 🔹 Delete a specialization
    @DeleteMapping("/{id}")
    public void deleteSpecialization(@PathVariable Long id) {
        specializationService.deleteSpecialization(id);
    }
}
