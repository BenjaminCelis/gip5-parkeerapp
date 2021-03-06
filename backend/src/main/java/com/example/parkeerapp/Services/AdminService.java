package com.example.parkeerapp.Services;


import com.example.parkeerapp.Converter.AdminConverter;
import com.example.parkeerapp.DTO.AdminDTO;
import com.example.parkeerapp.Domain.Admin;
import com.example.parkeerapp.Domain.User;
import com.example.parkeerapp.dao.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminConverter adminConverter;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public AdminService(AdminRepository adminRepository,AdminConverter adminConverter){
        this.adminRepository = adminRepository;
        this.adminConverter = adminConverter;
    }

    public AdminDTO createAdmin(AdminDTO adminDTO){
        Admin admin = adminConverter.dtoToAdmin(adminDTO);

        //set role
        admin.getUser().setRole("ADMIN");

        // password encoden
        admin.getUser().setPassword(passwordEncoder.encode(admin.getUser().getPassword()));


        System.out.println(admin.getUser().toString());
        adminRepository.save(admin);
        return adminConverter.adminDTO(admin);
    }

    public AdminDTO getAdminByUserId(User user){
        Admin admin = adminRepository.findByUser(user).orElseThrow();
        return adminConverter.adminDTO(admin);
    }

    public List<AdminDTO> getALL(){
        List<Admin> admins = adminRepository.findAll();
        return adminConverter.listToDto(admins);
    }
}
