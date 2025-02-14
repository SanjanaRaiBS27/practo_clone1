package com.practo.clone.service;

import com.practo.clone.dto.PracticeDTO;
import com.practo.clone.model.Doctor;
import com.practo.clone.model.DoctorPractice;
import com.practo.clone.model.Practice;
import com.practo.clone.repository.DoctorPracticeRepository;
import com.practo.clone.repository.DoctorRepository;
import com.practo.clone.repository.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PracticeService {

    @Autowired
    private PracticeRepository practiceRepository;

    @Autowired
    private DoctorRepository doctorRepository;


    @Autowired
    private DoctorPracticeRepository doctorPracticeRepository;

    public List<PracticeDTO> getAllPractices() {
        List<Practice> practices = practiceRepository.findAll();
        return practices.stream().map(practice -> new PracticeDTO(
                practice.getId(),
                practice.getName(),
                practice.getAddress(),
                practice.getCity(),
                practice.getState(),
                practice.getContactNumber(),
                practice.isWheelchairAccessible()
        )).collect(Collectors.toList());
    }

    public List<Practice> getPracticeById(String id) {
        List<Practice> practice = practiceRepository.findByNameContainingIgnoreCase(id);
        return practiceRepository.findByNameContainingIgnoreCase(id);
    }

    public PracticeDTO createPractice(PracticeDTO practiceDTO) {
        Practice practice = new Practice();
        practice.setName(practiceDTO.getName());
        practice.setAddress(practiceDTO.getAddress());
        practice.setCity(practiceDTO.getCity());
        practice.setState(practiceDTO.getState());
        practice.setContactNumber(practiceDTO.getContactNumber());
        practice.setWheelchairAccessible(practiceDTO.isWheelchairAccessible());

        Practice savedPractice = practiceRepository.save(practice);
        return new PracticeDTO(
                savedPractice.getId(),
                savedPractice.getName(),
                savedPractice.getAddress(),
                savedPractice.getCity(),
                savedPractice.getState(),
                savedPractice.getContactNumber(),
                savedPractice.isWheelchairAccessible()
        );
    }

    public PracticeDTO updatePractice(int id, PracticeDTO practiceDTO) {
        Optional<Practice> optionalPractice = practiceRepository.findById(id);
        if (optionalPractice.isPresent()) {
            Practice practice = optionalPractice.get();
            practice.setName(practiceDTO.getName());
            practice.setAddress(practiceDTO.getAddress());
            practice.setCity(practiceDTO.getCity());
            practice.setState(practiceDTO.getState());
            practice.setContactNumber(practiceDTO.getContactNumber());
            practice.setWheelchairAccessible(practiceDTO.isWheelchairAccessible());

            Practice updatedPractice = practiceRepository.save(practice);
            return new PracticeDTO(
                    updatedPractice.getId(),
                    updatedPractice.getName(),
                    updatedPractice.getAddress(),
                    updatedPractice.getCity(),
                    updatedPractice.getState(),
                    updatedPractice.getContactNumber(),
                    updatedPractice.isWheelchairAccessible()
            );
        } else {
            return null;
        }
    }

    public void deletePractice(int id) {
        practiceRepository.deleteById(id);
    }

    public List<PracticeDTO> getPracticesByCity(String city) {
        List<Practice> practices = practiceRepository.findByNameContainingIgnoreCase(city);
        return practices.stream().map(practice -> new PracticeDTO(
                practice.getId(),
                practice.getName(),
                practice.getAddress(),
                practice.getCity(),
                practice.getState(),
                practice.getContactNumber(),
                practice.isWheelchairAccessible()
        )).collect(Collectors.toList());
    }

    public Practice savePractice(Practice practice) {
        return practiceRepository.save(practice);
    }


    public List<Doctor> getAllDoctorInPractice(String practiceName) {
        // Find all practices with the given name
        List<Practice> practices = practiceRepository.findAllByName(practiceName);

        if (practices.isEmpty()) {
            throw new RuntimeException("Practice not found: " + practiceName);
        }

        // Assuming we need only the first match (or loop through all)
        Practice practice = practices.get(0); // Taking first one for simplicity
        int practiceId = practice.getId();

        // Fetch doctor-practice mappings
        List<DoctorPractice> doctorPractices = doctorPracticeRepository.findAllByPracticeId(practiceId);
        List<Integer> doctorIds = doctorPractices.stream()
                .map(DoctorPractice::getDoctorId)
                .collect(Collectors.toList());

        return doctorRepository.findAllById(doctorIds);
    }



}
