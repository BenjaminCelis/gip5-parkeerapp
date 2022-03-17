package com.example.parkeerapp.runner;

import com.example.parkeerapp.Domain.*;
import com.example.parkeerapp.dao.CarRepository;
import com.example.parkeerapp.dao.MemberRepository;
import com.example.parkeerapp.dao.ParkingspotRepository;
import com.example.parkeerapp.dao.ReservationRepository;
import org.springframework.boot.CommandLineRunner;

public class LineRunner implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final CarRepository carRepository;
    private final ParkingspotRepository parkingspotRepository;
    private final ReservationRepository reservationRepository;

    public LineRunner(MemberRepository memberRepository, CarRepository carRepository, ParkingspotRepository parkingspotRepository, ReservationRepository reservationRepository) {
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
        this.parkingspotRepository = parkingspotRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        Member benja = new Member("Benja","Celis","team7","member","benja@celis.be");
        memberRepository.save(benja);
        Member igor = new Member("Igor","Jemuce","team7","member","igor@jemuce.be");
        memberRepository.save(igor);

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
            for (int j = 0; j < 20; j++) {
                Parkingspot p = new Parkingspot(i,j);
                parkingspotRepository.save(p);
            }

        }

    }
}
