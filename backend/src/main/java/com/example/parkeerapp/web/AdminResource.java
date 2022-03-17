package com.example.parkeerapp.web;

import com.example.parkeerapp.DTO.AdminDTO;
import com.example.parkeerapp.Services.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:3000/")
public class AdminResource {

    private final AdminService adminService;

    public AdminResource(AdminService adminService){this.adminService = adminService ;}

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public AdminDTO createAdmin(@RequestBody AdminDTO adminDTO){
        return adminService.createAdmin(adminDTO);
    }

    @GetMapping
    public List<AdminDTO> getALLAdmins(){
        return adminService.getALL();
    }
}
