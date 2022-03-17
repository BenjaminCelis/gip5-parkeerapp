package com.example.parkeerapp.web;

import com.example.parkeerapp.Services.ParkingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResource {

    private final ParkingService service;


    public UserResource(ParkingService service) {
        this.service = service;
    }
}
