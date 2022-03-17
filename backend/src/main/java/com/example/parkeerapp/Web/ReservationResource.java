package com.example.parkeerapp.web;

import com.example.parkeerapp.Domain.Parkingspot;
import com.example.parkeerapp.Domain.Reservation;
import com.example.parkeerapp.Services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationResource {
    private final ParkingService service;

    @Autowired

    public ReservationResource(ParkingService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getReservations(){
        return ResponseEntity.ok(service.getReservations());
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<Reservation> getReservation(@PathVariable("reservationId") Long reservationId){
    if(reservationId<1)
            return ResponseEntity.badRequest().build();
        if(!service.reservationExists(reservationId))
            return ResponseEntity.notFound().build();
        Reservation reservation =  service.getReservation(reservationId);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<Reservation>> getMemberReservations(@PathVariable("memberId") Long memberId){
        if(service.memberExists(memberId)){
            return ResponseEntity.ok(service.getMemberReservations(memberId));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
