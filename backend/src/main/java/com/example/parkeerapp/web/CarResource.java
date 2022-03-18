package com.example.parkeerapp.web;

import com.example.parkeerapp.DTO.CarDTO;
import com.example.parkeerapp.Domain.Car;
import com.example.parkeerapp.Services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



    @GetMapping("/{userId}")
    public ResponseEntity<List<Car>> getUserCars(@PathVariable("userId") Long userId){
        if(!service.userExists(userId)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(service.getUserCars(userId));

    }


    @GetMapping
    public ResponseEntity<List<Car>> getCars(){
        return ResponseEntity.ok(service.getCars());
    }

    @PostMapping
    public ResponseEntity<Car> makeCar(@RequestBody CarDTO carDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.makeCar(carDTO));
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity deleteCar(@PathVariable("carId") Long carId){
        if(carId<1) return ResponseEntity.badRequest().build();
        if(!service.carExists(carId)) return ResponseEntity.notFound().build();

        service.deleteCar(carId);
        return ResponseEntity.ok().build();
    }
}
