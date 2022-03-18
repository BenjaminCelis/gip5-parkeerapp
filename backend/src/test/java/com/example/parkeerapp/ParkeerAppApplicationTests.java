package com.example.parkeerapp;

import com.example.parkeerapp.DTO.ReservationDTO;
import com.example.parkeerapp.Domain.*;
import com.example.parkeerapp.Services.ParkingService;
import com.example.parkeerapp.dao.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.*;

@Transactional
@SpringBootTest
class ParkeerAppApplicationTests {



    @Autowired
    private WebApplicationContext wac;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ParkingspotRepository parkingspotRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    ParkingService parkingService;

    private MockMvc mockMvc;

    Member testMember;
    Car testCar;
    Reservation testReservation;
    Parkingspot testParkingspot;
    LocalDate now;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        now = LocalDate.now();
        User testUser = new User("testFN", "testLN","pw","Member","E@ma.il" );
        testMember = new Member(testUser);
        testCar = new Car(testUser,"0-ABC-123", "WHITE", "Ford");
        testParkingspot = new Parkingspot(0,1);
        testReservation = new Reservation(testParkingspot,testCar,now,LocalDateTime.of(2022,10,20,8,0),LocalDateTime.of(2022,10,20,20,0));
    }
    @Test
    void contextLoads() {
    }

    @Test
    void makesNewMember() throws Exception{
        testMember = memberRepository.save(testMember);
        assertNotNull(testMember.getId());
        Optional<Member> madeMemberOpt = memberRepository.findById(testMember.getId());
        assertTrue(madeMemberOpt.isPresent());
        Member madeMember = madeMemberOpt.get();

        assertEquals(madeMember.getUser().getFirstname(),testMember.getUser().getFirstname());
        assertEquals(madeMember.getUser().getLastname(),testMember.getUser().getLastname());
        assertEquals(madeMember.getUser().getEmail(),testMember.getUser().getEmail());
        assertEquals(madeMember.getUser().getPassword(),testMember.getUser().getPassword());
        assertEquals(madeMember.getUser().getRole(),testMember.getUser().getRole());

    }

    @Test
    void makesNewCar() throws Exception{
        testCar = carRepository.save(testCar);
        assertNotNull(testCar.getId());
        Optional<Car> madeCarOpt = carRepository.findById(testCar.getId());
        assertTrue(madeCarOpt.isPresent());
        Car madeCar = madeCarOpt.get();
        assertEquals(madeCar.getBrand(),testCar.getBrand());
        assertEquals(madeCar.getColor(),testCar.getColor());
        assertEquals(madeCar.getLicensePlate(),testCar.getLicensePlate());
    }
    @Test
    void makesNewParkingspot() throws Exception{
        testParkingspot = parkingspotRepository.save(testParkingspot);
        assertNotNull(testParkingspot.getId());
        Optional<Parkingspot> madeParkingspotOpt = parkingspotRepository.findById(testParkingspot.getId());
        assertTrue(madeParkingspotOpt.isPresent());
        Parkingspot madeParkingspot = madeParkingspotOpt.get();

        assertEquals(madeParkingspot.getFloor(),testParkingspot.getFloor());
        assertEquals(madeParkingspot.getSpot(),testParkingspot.getSpot());
        assertEquals(madeParkingspot.getSpotCode(),testParkingspot.getSpotCode());
    }

    @Test
    void makesNewReservation() throws Exception{
        testReservation = reservationRepository.save(testReservation);
        assertNotNull(testReservation.getId());
        Optional<Reservation> madeReservationOpt = reservationRepository.findById(testReservation.getId());
        assertTrue(madeReservationOpt.isPresent());
        Reservation madeReservation = madeReservationOpt.get();

        assertEquals(madeReservation.getReservationDate(),testReservation.getReservationDate());
        assertEquals(madeReservation.getCar(),testReservation.getCar());
        assertEquals(madeReservation.getEndTime(),testReservation.getEndTime());
        assertEquals(madeReservation.getParkingspot(),testReservation.getParkingspot());
        assertEquals(madeReservation.getStartTime(),testReservation.getStartTime());
    }

    @Test
    void newReservationOnTakenSpotThrowsException(){
        testReservation = reservationRepository.save(testReservation);
        Reservation madeReservation = reservationRepository.findById(testReservation.getId()).get();

        ReservationDTO badReservation = new ReservationDTO(Long.parseLong("0"),LocalDateTime.of(2022,10,20,15,0),LocalDateTime.of(2022,10,21,20,0),Long.parseLong("0"),Long.parseLong("0"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> { parkingService.makeReservation(badReservation);},"");

    }
}
