package com.practo.clone.controller;

import com.practo.clone.dto.DoctorDTO;
import com.practo.clone.model.Doctor;
import com.practo.clone.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("doctor-name/{id}")
    public List<Doctor> getDoctorById(@PathVariable String id) {
        return doctorService.getDoctorByName(id);
    }

    @PostMapping
    public DoctorDTO createDoctor(@RequestBody DoctorDTO doctorDTO) {
        return doctorService.createDoctor(doctorDTO);
    }

    @PutMapping("/{id}")
    public DoctorDTO updateDoctor(@PathVariable int id, @RequestBody DoctorDTO doctorDTO) {
        return doctorService.updateDoctor(id, doctorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
    }
}