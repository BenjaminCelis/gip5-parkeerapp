package com.example.parkeerapp.runner;

import com.example.parkeerapp.Domain.*;
import com.example.parkeerapp.dao.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Component
public class LineRunner implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final CarRepository carRepository;
    private final ParkingspotRepository parkingspotRepository;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;


    public LineRunner(MemberRepository memberRepository, CarRepository carRepository, ParkingspotRepository parkingspotRepository, ReservationRepository reservationRepository, UserRepository userRepository) {
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
        this.parkingspotRepository = parkingspotRepository;
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        User benja = new User("Benja","Celis","team7","member","benja@celis.be");
        userRepository.save(benja);
        User igor = new User("Igor","Jemuce","team7","member","igor@jemuce.be");
        userRepository.save(igor);

        Car lambo = new Car(igor, "1-NWG-502","YELLOW", "Lamborgini");
        Car fera = new Car(igor, "BALLER","RED", "Ferrari");
        Car porsche = new Car(igor, "1-PLA-508","GREY", "Porsche");
        carRepository.save(lambo);
        carRepository.save(fera);
        carRepository.save(porsche);
        Car ford = new Car(benja, "1-ABC-123","WHITE", "Ford");
        Car fiat = new Car(benja, "1-OOO-000","PINK", "Fiat");
        Car tyt = new Car(benja, "1-ZZZ-999","BLACK", "Toyota");
        carRepository.save(ford);
        carRepository.save(fiat);
        carRepository.save(tyt);




        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 20; j++) {
                Parkingspot p = new Parkingspot(i,j);
                parkingspotRepository.save(p);
            }
        }
        Reservation r = new Reservation();
        r.setCar(tyt);
        Long R = Long.parseLong("3");
        r.setParkingspot(parkingspotRepository.getById(R));
        Date d = new Date();
        d.setYear(122);
        d.setMonth(3);
        d.setDate(16);
        d.setHours(3);
        d.setMinutes(30);
        d.setSeconds(0);
        r.setStartTime(d);
        Date b = new Date();
        b.setYear(122);
        b.setMonth(3);
        b.setDate(20);
        b.setHours(3);
        b.setMinutes(30);
        b.setSeconds(0);
        r.setEndTime(b);
        r.setReservationDate(new Date());
        reservationRepository.save(r);

    }
}
