package com.practo.clone.dto;

public class DoctorDTO {
    private int id;
    private String name;
    private String qualifications;
    private int experienceYears;
    private String bio;

    // Constructors
    public DoctorDTO() {}

    public DoctorDTO(int id, String name, String qualifications, int experienceYears, String bio) {
        this.id = id;
        this.name = name;
        this.qualifications = qualifications;
        this.experienceYears = experienceYears;
        this.bio = bio;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getQualifications() { return qualifications; }
   // public void setQualifications(String qualifications) { this.qualifications = qualifications; }
    public int getExperienceYears() { return experienceYears; }
   // public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }
    public String getBio() { return bio; }
   // public void setBio(String bio) { this.bio = bio; }
}

