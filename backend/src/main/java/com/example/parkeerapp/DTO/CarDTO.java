package com.example.parkeerapp.DTO;

public class CarDTO {

    private Long id;
    private String brand;
    private String color;
    private String licensePlate;
    private Long ownerId;

    public CarDTO() {
    }

    public CarDTO(String brand, String color, String licensePlate, Long ownerId) {
        this.brand = brand;
        this.color = color;
        this.licensePlate = licensePlate;
        this.ownerId = ownerId;
    }

    public CarDTO(Long id, String brand, String color, String licensePlate, Long ownerId) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.licensePlate = licensePlate;
        this.ownerId = ownerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
