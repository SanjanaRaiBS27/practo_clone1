package com.practo.clone.controller;

import com.practo.clone.dto.PracticeDTO;
import com.practo.clone.dto.SpecializationDTO;
import com.practo.clone.model.Doctor;
import com.practo.clone.model.DoctorPractice;
import com.practo.clone.model.Practice;
import com.practo.clone.service.PracticeService;
import com.practo.clone.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practices")
@CrossOrigin(origins = "http://127.0.0.1:5500") // Update to match frontend URL
public class PracticeController {

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private SpecializationService specializationService;

    // ✅ Get All Practices
    @GetMapping
    public List<PracticeDTO> getAllPractices() {
        return practiceService.getAllPractices();
    }

    // ✅ Get Practice by ID
    @GetMapping("practice-name/{practicename}")
    public List<Practice> getPracticeById(@PathVariable String practicename) {
        return practiceService.getPracticeById(practicename);
    }

    // ✅ Get Specializations for a Practice
    @GetMapping("/{id}/specializations")
    public List<SpecializationDTO> getSpecializationsByPractice(@PathVariable int id) {
        return specializationService.getSpecializationsByPractice((long) id);
    }

    // ✅ Create Practice
    @PostMapping
    public PracticeDTO createPractice(@RequestBody PracticeDTO practiceDTO) {
        return practiceService.createPractice(practiceDTO);
    }

    // ✅ Update Practice
    @PutMapping("/{id}")
    public PracticeDTO updatePractice(@PathVariable int id, @RequestBody PracticeDTO practiceDTO) {
        return practiceService.updatePractice(id, practiceDTO);
    }

    // ✅ Delete Practice
    @DeleteMapping("/{id}")
    public void deletePractice(@PathVariable int id) {
        practiceService.deletePractice(id);
    }

    // http://localhost:8080/practices/all-doctors/practice-id/{practiceName}
    @GetMapping(value = "/all-doctors/practice-id/{practiceName}")
    public List<Doctor> getAllDoctorsFromPracticename(@PathVariable String practiceName){
        return practiceService.getAllDoctorInPractice(practiceName);
    }
}
