package com.example.parkeerapp.web;

import com.example.parkeerapp.Services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarResource {
    private final ParkingService service;

    @Autowired

    public CarResource(ParkingService service) {
        this.service = service;
    }
}
