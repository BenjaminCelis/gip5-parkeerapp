package com.example.parkeerapp.dao;

import com.example.parkeerapp.Domain.Parkingspot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingspotRepository extends JpaRepository<Parkingspot, Long>{
}
