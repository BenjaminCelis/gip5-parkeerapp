package com.example.parkeerapp.web;

import com.example.parkeerapp.DTO.ReservationDTO;
import com.example.parkeerapp.Domain.Parkingspot;
import com.example.parkeerapp.Domain.Reservation;
import com.example.parkeerapp.Services.ParkingService;
import com.github.dockerjava.api.exception.NotFoundException;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@CrossOrigin("http://localhost:3000/")
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
    @GetMapping("/user/{userId}")

    public ResponseEntity<List<Reservation>> getUserReservations(@PathVariable("userId") Long userId){
        if(service.userExists(userId)){
            return ResponseEntity.ok(service.getMemberReservations(userId));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Reservation> makeReservation(@RequestBody ReservationDTO reservation){
        if(reservation.getCarId() == null || reservation.getParkingspotId() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(reservation.getCarId() <= 0 || reservation.getParkingspotId() <= 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(service.makeReservation(reservation));
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity deleteReservation(@PathVariable("reservationId") Long reservationId){
        if(reservationId<1) return ResponseEntity.badRequest().build();
        if(!service.reservationExists(reservationId)) return ResponseEntity.notFound().build();

        service.deleteReservation(reservationId);
        return ResponseEntity.ok().build();
    }
}
