package com.practo.clone.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Doctor_Practice")
public class DoctorPractice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int doctorId;
    private int practiceId;
    private String availability;
    private double consultationFee;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public int getPracticeId() { return practiceId; }
    public void setPracticeId(int practiceId) { this.practiceId = practiceId; }
    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }
    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }
}