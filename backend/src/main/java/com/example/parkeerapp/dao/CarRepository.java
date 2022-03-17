package com.example.parkeerapp.dao;

import com.example.parkeerapp.Domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
