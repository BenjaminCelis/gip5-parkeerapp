package com.example.parkeerapp.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "parkingspot_id")
    private Parkingspot parkingspot;

    @ManyToOne
    @JoinColumn(name = "car_ID")
    private Car car;

    public Reservation() {
    }

    @Column(name = "reservationDate")
    private LocalDate reservationDate;

    @Column(name = "endTime")
    @JsonFormat(pattern = "dd-MM-yyy HH:mm")
    private LocalDateTime endTime;

    @Column(name = "startTime")
    @JsonFormat(pattern = "dd-MM-yyy HH:mm")
    private LocalDateTime startTime;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public Parkingspot getParkingspot() {
        return parkingspot;
    }

    public void setParkingspot(Parkingspot parkingspot) {
        this.parkingspot = parkingspot;
    }



    public Reservation(long id, LocalDate reservationDate, LocalDateTime endTime, LocalDateTime startTime) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public Reservation(Parkingspot parkingspot, Car car, LocalDate reservationDate, LocalDateTime endTime, LocalDateTime startTime) {
        this.parkingspot = parkingspot;
        this.car = car;
        this.reservationDate = reservationDate;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }


}
