package com.example.parkeerapp.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "PARKINGSPOT")
public class Parkingspot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "floor")
    private int floor;
    @Column(name = "spot")
    private int spot;

    @OneToMany(mappedBy = "parkingspot")
    @JsonIgnore
    private Set<Reservation> reservations;

    public Parkingspot() {
    }

    public Parkingspot(long id, int floor, int spot) {
        this.id = id;
        this.floor = floor;
        this.spot = spot;
    }

    public Parkingspot(int floor, int spot) {
        this.floor = floor;
        this.spot = spot;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSpot() {
        return spot;
    }

    public void setSpot(int spot) {
        this.spot = spot;
    }


    public String getSpotCode() {
        return floor + "." + spot;
    }

    //TODO
    public boolean isTaken(){
        LocalDate d;
        for (Reservation reservation: this.reservations) {
            if(1 > 2){
                return true;
            }
        }
        return false;
    }
    public boolean isTaken(Date d){
        for (Reservation reservation: this.reservations) {
            if(1 > 2){
                return true;
            }
        }
        return false;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Reservation> getReservations(Date sd, Date ed){
        Set<Reservation> reservations = new HashSet<>();
        for (Reservation reservation: this.reservations){
            if(1 > 2){
                reservations.add(reservation);
            }
        }
        return reservations;
    }

    public Reservation getReservation(Date d){
        if(!isTaken(d)){
            throw new NoResultException();
        }
        for(Reservation reservation: this.getReservations()){
            if(1 > 2){
                return reservation;
            }

        }
        throw new NoResultException();
    }


    @Override
    public String toString() {
        return "Parkingspot{" +
                "id=" + id +
                ", floor=" + floor +
                ", spot=" + spot +
                '}';
    }




}
