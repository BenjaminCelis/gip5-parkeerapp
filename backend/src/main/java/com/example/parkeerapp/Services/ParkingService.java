package com.example.parkeerapp.Services;

import com.example.parkeerapp.Domain.Car;
import com.example.parkeerapp.Domain.Member;
import com.example.parkeerapp.Domain.Parkingspot;
import com.example.parkeerapp.Domain.Reservation;
import com.example.parkeerapp.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ParkingService {

    private final AdminRepository adminRepository;
    private final MemberRepository memberRepository;
    private final CarRepository carRepository;
    private final ParkingspotRepository parkingspotRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ParkingService(AdminRepository adminRepository, MemberRepository memberRepository, CarRepository carRepository, ParkingspotRepository parkingspotRepository, ReservationRepository reservationRepository) {
        this.adminRepository = adminRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
        this.parkingspotRepository = parkingspotRepository;
        this.reservationRepository = reservationRepository;
    }

    //MEMBER
    public boolean memberExists(Long memberId){
        return memberRepository.existsById(memberId);
    }

    //CARS
    public Car makeCar(Car car){
        return carRepository.save(car);
    }
    public boolean carExists(Long carId){
        return carRepository.existsById(carId);
    }

    //PARKINGSPOTS
    public List<Parkingspot> getParkingspots() {
        return parkingspotRepository.findAll();
    }
    public List<Parkingspot> getFreeParkingspots(){
        List<Parkingspot> freeSpots = new ArrayList<>();
        for (Parkingspot p:parkingspotRepository.findAll()) {
            if(!p.isTaken()){freeSpots.add(p);}
        }
        return freeSpots;
    }
    //TODO
    public List<Parkingspot> getFreeParkingspots(Date d){
        List<Parkingspot> takenSpots = new ArrayList<>();

        return takenSpots;
    }

    //RESERVATIONS



    public List<Reservation> getReservations(){
        return reservationRepository.findAll();
    }

    public boolean reservationExists(Long reservationId){
        return reservationRepository.existsById(reservationId);
    }
    public Reservation getReservation(Long reservationId){
        return reservationRepository.findById(reservationId).orElseThrow();
    }


    public List<Reservation> getMemberReservations(Long memberId){
        if(!memberExists(memberId)){
            throw new IllegalArgumentException();
        }
        List<Reservation> reservations = new ArrayList<>();
        Member member = memberRepository.findById(memberId).get();
        for(Car car: member.getCars()){
            reservations.addAll(car.getReservations());
        }
        return reservations;
    }
}
