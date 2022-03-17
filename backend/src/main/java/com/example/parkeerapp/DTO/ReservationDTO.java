package com.example.parkeerapp.DTO;


import java.time.LocalDateTime;

public class ReservationDTO {

        private Long id;
        private LocalDateTime startTime;
        private LocalDateTime endTime;

        private Long carId;
        private Long parkingspotId;

    public ReservationDTO(Long id, LocalDateTime startTime, LocalDateTime endTime,  Long carId, Long parkingspotId) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;

        this.carId = carId;
        this.parkingspotId = parkingspotId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }



    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getParkingspotId() {
        return parkingspotId;
    }

    public void setParkingspotId(Long parkingspotId) {
        this.parkingspotId = parkingspotId;
    }
}
