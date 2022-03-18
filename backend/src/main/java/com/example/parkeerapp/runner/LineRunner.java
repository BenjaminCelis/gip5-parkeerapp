package com.example.parkeerapp.runner;

import com.example.parkeerapp.Domain.*;
import com.example.parkeerapp.dao.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
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
        Car fera = new Car(igor, "1-BAl-730","RED", "Ferrari");
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
        r.setReservationDate(LocalDate.now());
        r.setEndTime(LocalDateTime.of(2022,3,20,4, 30));
        r.setStartTime(LocalDateTime.of(2022,3,16,16, 30));
        reservationRepository.save(r);


        Reservation i = new Reservation();
        i.setCar(fera);
        Long A = Long.parseLong("39");
        i.setParkingspot(parkingspotRepository.getById(A));
        i.setReservationDate(LocalDate.now());
        i.setEndTime(LocalDateTime.of(2022,3,20,9, 00));
        i.setStartTime(LocalDateTime.of(2022,3,20,20, 30));
        reservationRepository.save(i);




    }
}
