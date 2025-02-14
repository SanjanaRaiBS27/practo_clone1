package com.practo.clone.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Doctor_Specializations")
public class DoctorSpecialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int doctorId;
    private int specializationId;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public int getSpecializationId() { return specializationId; }
    public void setSpecializationId(int specializationId) { this.specializationId = specializationId; }
}
