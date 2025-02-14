package com.practo.clone.model;

import jakarta.persistence.*;

@Entity
@Table(name = "specializations") // Use lowercase naming convention
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY) // Optimized fetching
    @JoinColumn(name = "practice_id", nullable = false)
    private Practice practice;

    // Default constructor
    public Specialization() {}

    // Parameterized constructor
    public Specialization(int id, String name, String description, Practice practice) {
        this.id = id;
        this.name = name;
        this.description = description;
        //this.practice = practice;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
    }
}
