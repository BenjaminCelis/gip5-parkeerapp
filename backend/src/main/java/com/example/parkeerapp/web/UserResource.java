package com.example.parkeerapp.web;

import com.example.parkeerapp.Domain.Parkingspot;
import com.example.parkeerapp.Domain.User;
import com.example.parkeerapp.Services.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000/")
public class UserResource {

    private final ParkingService service;


    public UserResource(ParkingService service) {
        this.service = service;


    }
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(service.getUsers( ));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") Long userId){
        if(userId<1)
            return ResponseEntity.badRequest().build();
        if(!service.userExists(userId))
            return ResponseEntity.notFound().build();
        User user =  service.getUser(userId);
        return ResponseEntity.ok(user);
    }
}
