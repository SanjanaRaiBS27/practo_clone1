package com.practo.clone.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Practice_Specializations")
public class PracticeSpecialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int practiceId;
    private int specializationId;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getPracticeId() { return practiceId; }
    public void setPracticeId(int practiceId) { this.practiceId = practiceId; }
    public int getSpecializationId() { return specializationId; }
    public void setSpecializationId(int specializationId) { this.specializationId = specializationId; }
}

