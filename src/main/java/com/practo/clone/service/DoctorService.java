package com.practo.clone.service;

import com.practo.clone.dto.DoctorDTO;
import com.practo.clone.model.Doctor;
import com.practo.clone.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;



    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<Doctor> getDoctorByName(String name) {

        return doctorRepository.findByNameContainingIgnoreCase(name);
    }

//    public List<DoctorDTO> searchDoctorsByName(String name) {
//        List<Doctor> doctors = doctorRepository.findByNameContainingIgnoreCase(name);
//        return doctors.stream().map(this::convertToDTO).collect(Collectors.toList());
//    }

    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = convertToEntity(doctorDTO);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return convertToDTO(savedDoctor);
    }

    public DoctorDTO updateDoctor(int id, DoctorDTO doctorDTO) {
        return doctorRepository.findById(id).map(doctor -> {
            doctor.setName(doctorDTO.getName());
            doctor.setQualifications(doctorDTO.getQualifications());
            doctor.setExperienceYears(doctorDTO.getExperienceYears());
            doctor.setBio(doctorDTO.getBio());
            return convertToDTO(doctorRepository.save(doctor));
        }).orElse(null);
    }

    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    private DoctorDTO convertToDTO(Doctor doctor) {
        return new DoctorDTO(
                doctor.getId(),
                doctor.getName(),
                doctor.getQualifications(),
                doctor.getExperienceYears(),
                doctor.getBio()
        );
    }

    private Doctor convertToEntity(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        doctor.setQualifications(doctorDTO.getQualifications());
        doctor.setExperienceYears(doctorDTO.getExperienceYears());
        doctor.setBio(doctorDTO.getBio());
        return doctor;
    }
}
