package com.practo.clone.dto;

public class SpecializationDTO {
    private int id;
    private String name;
    private String description;

    // Constructors
    public SpecializationDTO() {}

    public SpecializationDTO(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    //public void setDescription(String description) { this.description = description; }
}