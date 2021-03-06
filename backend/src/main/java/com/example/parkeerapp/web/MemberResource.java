package com.example.parkeerapp.web;


import com.example.parkeerapp.DTO.CreateMemberDTO;
import com.example.parkeerapp.DTO.CreateUserDTO;
import com.example.parkeerapp.DTO.MemberDTO;
import com.example.parkeerapp.Services.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@CrossOrigin("http://localhost:3000/")
public class MemberResource {

    private final MemberService memberService;

    public MemberResource(MemberService memberService){this.memberService = memberService ;}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public MemberDTO createMember(@RequestBody CreateUserDTO createUserDTO){

        return memberService.createMember(createUserDTO);
    }

    @GetMapping
    public List<MemberDTO> getAllMembers(){return memberService.getAllMembers();}

}
