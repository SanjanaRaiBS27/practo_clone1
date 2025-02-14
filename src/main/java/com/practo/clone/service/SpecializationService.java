package com.practo.clone.service;

import com.practo.clone.dto.SpecializationDTO;
import com.practo.clone.model.Specialization;
import com.practo.clone.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpecializationService {

    @Autowired
    private SpecializationRepository specializationRepository;

    public List<SpecializationDTO> getAllSpecializations() {
        List<Specialization> specializations = specializationRepository.findAll();
        return specializations.stream()
                .map(spec -> new SpecializationDTO(
                        spec.getId(),
                        spec.getName(),
                        spec.getDescription()
                )).collect(Collectors.toList());
    }

    public SpecializationDTO getSpecializationById(Long id) {
        Optional<Specialization> specialization = specializationRepository.findById(id);
        return specialization.map(spec -> new SpecializationDTO(
                spec.getId(),
                spec.getName(),
                spec.getDescription()
        )).orElse(null);
    }

    public SpecializationDTO createSpecialization(SpecializationDTO specializationDTO) {
        Specialization specialization = new Specialization();
        specialization.setName(specializationDTO.getName());
        specialization.setDescription(specializationDTO.getDescription());

        Specialization savedSpecialization = specializationRepository.save(specialization);
        return new SpecializationDTO(
                savedSpecialization.getId(),
                savedSpecialization.getName(),
                savedSpecialization.getDescription()
        );
    }

    public SpecializationDTO updateSpecialization(Long id, SpecializationDTO specializationDTO) {
        Optional<Specialization> optionalSpecialization = specializationRepository.findById(id);
        if (optionalSpecialization.isPresent()) {
            Specialization specialization = optionalSpecialization.get();
            specialization.setName(specializationDTO.getName());
            specialization.setDescription(specializationDTO.getDescription());

            Specialization updatedSpecialization = specializationRepository.save(specialization);
            return new SpecializationDTO(
                    updatedSpecialization.getId(),
                    updatedSpecialization.getName(),
                    updatedSpecialization.getDescription()
            );
        } else {
            return null;
        }
    }

    public void deleteSpecialization(Long id) {
        specializationRepository.deleteById(id);
    }

    public Specialization saveSpecialization(Specialization specialization) {
        return specializationRepository.save(specialization);
    }

    // ✅ Get Specializations Linked to a Practice
    public List<SpecializationDTO> getSpecializationsByPractice(Long practiceId) {
        List<Specialization> specializations = specializationRepository.findByPracticeId(practiceId);
        return specializations.stream()
                .map(spec -> new SpecializationDTO(
                        spec.getId(),
                        spec.getName(),
                        spec.getDescription()
                )).collect(Collectors.toList());
    }

    // ✅ Get Specialization by Name (Fix for Search API)
    public List<SpecializationDTO> getSpecializationsByName(String specializationName) {
        List<Specialization> specializations = specializationRepository.findByNameContainingIgnoreCase(specializationName);
        return specializations.stream()
                .map(spec -> new SpecializationDTO(
                        spec.getId(),
                        spec.getName(),
                        spec.getDescription()
                )).collect(Collectors.toList());
    }
}
