package com.example.parkeerapp.Domain;

import javax.persistence.*;
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
    private Date reservationDate;

    @Column(name = "endTime")
    private Date endTime;

    @Column(name = "startTime")
    private Date startTime;

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



    public Reservation(long id, Date reservationDate, Date endTime, Date startTime) {
        this.id = id;
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

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }


}
