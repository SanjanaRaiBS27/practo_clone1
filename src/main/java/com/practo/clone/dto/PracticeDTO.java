package com.practo.clone.dto;

public class PracticeDTO {
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String contactNumber;
    private boolean wheelchairAccessible;

    // Constructors
   // public PracticeDTO() {}

    public PracticeDTO(int id, String name, String address, String city, String state, String contactNumber, boolean wheelchairAccessible) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.contactNumber = contactNumber;
        this.wheelchairAccessible = wheelchairAccessible;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    //public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
   // public void setState(String state) { this.state = state; }
    public String getContactNumber() { return contactNumber; }
   // public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public boolean isWheelchairAccessible() { return wheelchairAccessible; }
   // public void setWheelchairAccessible(boolean wheelchairAccessible) { this.wheelchairAccessible = wheelchairAccessible; }
}
