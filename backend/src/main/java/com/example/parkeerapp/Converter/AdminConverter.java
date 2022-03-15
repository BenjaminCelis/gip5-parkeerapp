package com.example.parkeerapp.Converter;

import com.example.parkeerapp.DTO.AdminDTO;
import com.example.parkeerapp.Domain.Admin;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminConverter {

    MemberConverter memberConverter = new MemberConverter();

    public AdminDTO adminDTO(Admin admin){
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(adminDTO.getId());
        adminDTO.setMemberDTO(memberConverter.memberToDTO(admin.getMember()));
        return adminDTO;
    }

    public Admin dtoToAdmin(AdminDTO adminDTO){
        Admin admin = new Admin();
        admin.setId(adminDTO.getId());
        admin.setMember(memberConverter.memberDTOtoMember(adminDTO.getMemberDTO()));
        admin.getMember().setPassword(adminDTO.getPasswoord());
        return admin;
    }

    public List<AdminDTO> listToDto(List<Admin> admins){
        return admins.stream().map(this::adminDTO).collect(Collectors.toList());
    }
}
