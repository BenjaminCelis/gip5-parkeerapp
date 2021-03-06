package com.example.parkeerapp.dao;

import com.example.parkeerapp.Domain.Admin;
import com.example.parkeerapp.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUser(User user);
}
