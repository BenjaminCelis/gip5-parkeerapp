package com.example.parkeerapp.Services;

import com.example.parkeerapp.Domain.Parkingspot;
import com.example.parkeerapp.Domain.Reservation;
import com.example.parkeerapp.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkeerService {

    private final AdminRepository adminRepository;
    private final MemberRepository memberRepository;
    private final CarRepository carRepository;
    private final ParkingspotRepository parkingspotRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ParkeerService(AdminRepository adminRepository, MemberRepository memberRepository, CarRepository carRepository, ParkingspotRepository parkingspotRepository, ReservationRepository reservationRepository) {
        this.adminRepository = adminRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
        this.parkingspotRepository = parkingspotRepository;
        this.reservationRepository = reservationRepository;
    }


}
