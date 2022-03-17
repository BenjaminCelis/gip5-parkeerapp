package com.example.parkeerapp.Domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Car(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Car() {
    }

    @OneToMany(mappedBy = "car")
    private Set<Reservation> reservations;
    @Column(name = "licensePlate")
    private String licensePlate;
    @Column(name = "color")
    private String color;
    @Column(name = "brand")
    private String brand;


    public Car(long id, Member member, String licensePlate, String color, String brand) {
        this.id = id;
        this.member = member;
        this.licensePlate = licensePlate;
        this.color = color;
        this.brand = brand;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Member getOwner() {
        return member;
    }

    public void setOwner(Member member) {
        this.member = member;
    }


}
