package com.example.parkeerapp.web;

import com.example.parkeerapp.Domain.Parkingspot;
import com.example.parkeerapp.Services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/parkingspot")
public class ParkingspotResource {

    private final ParkingService service;

    @Autowired

    public ParkingspotResource(ParkingService service) {
        this.service = service;
    }

    //@ApiOperation("Haalt alle parkeerplaatsen op")
    @GetMapping
    public ResponseEntity<List<Parkingspot>> getParkingspots(){
        return ResponseEntity.ok(service.getParkingspots());
    }

}
