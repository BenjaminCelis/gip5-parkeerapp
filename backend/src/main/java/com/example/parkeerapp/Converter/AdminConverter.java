package com.example.parkeerapp.Converter;

import com.example.parkeerapp.DTO.AdminDTO;
import com.example.parkeerapp.Domain.Admin;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminConverter {

    UserConverter userConverter = new UserConverter();

    public AdminDTO adminDTO(Admin admin){
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(adminDTO.getId());
        adminDTO.setUserDTO(userConverter.userToDTO(admin.getUser()));
        return adminDTO;
    }

    public Admin dtoToAdmin(AdminDTO adminDTO){
        Admin admin = new Admin();
        admin.setId(adminDTO.getId());
        admin.setUser(userConverter.userDTOtoUser(adminDTO.getUserDTO()));
        admin.getUser().setPassword(adminDTO.getPasswoord());;
        return admin;
    }

    public List<AdminDTO> listToDto(List<Admin> admins){
        return admins.stream().map(this::adminDTO).collect(Collectors.toList());
    }
}
