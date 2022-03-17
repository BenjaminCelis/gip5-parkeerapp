package com.example.parkeerapp.web;

import com.example.parkeerapp.Domain.Car;
import com.example.parkeerapp.Services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
@CrossOrigin("http://localhost:3000/")
public class CarResource {
    private final ParkingService service;

    @Autowired

    public CarResource(ParkingService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Car>> getCars(){
        return ResponseEntity.ok(service.getCars());
    }
}
