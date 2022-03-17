package com.example.parkeerapp.Services;

import com.example.parkeerapp.DTO.UserDTO;
import com.example.parkeerapp.Domain.*;
import com.example.parkeerapp.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private final UserRepository userRepository;


    @Autowired
    public ParkingService(AdminRepository adminRepository, MemberRepository memberRepository, CarRepository carRepository, ParkingspotRepository parkingspotRepository, ReservationRepository reservationRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
        this.parkingspotRepository = parkingspotRepository;
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    //MEMBER
    public boolean memberExists(Long memberId){
        return memberRepository.existsById(memberId);
    }

    //USER
    public boolean userExists(Long userId){
        return userRepository.existsById(userId);
    }


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long userId) {
        if(!userExists(userId)) throw new IllegalArgumentException();
        return userRepository.findById(userId).get();
    }

    //CARS
    public List<Car> getUserCars(Long userId) {
            User user = getUser(userId);
            List<Car>cars = new ArrayList<>();
        for (Car car: user.getCars()) {
            cars.add(car);
        }
        return cars;
    }

    public Car makeCar(Car car){
        return carRepository.save(car);
    }
    public boolean carExists(Long carId){
        return carRepository.existsById(carId);
    }
    public List<Car> getCars(){
        return carRepository.findAll();
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
    public List<Parkingspot> getFreeParkingspots(LocalDateTime d){
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
        User user = userRepository.findById(memberId).get();
        for(Car car: user.getCars()){
            reservations.addAll(car.getReservations());
        }
        return reservations;
    }

    public Reservation makeReservation(Reservation reservation) {
        reservation.setReservationDate(LocalDate.now());
        reservation = reservationRepository.save(reservation);
        return reservation;
    }



}
