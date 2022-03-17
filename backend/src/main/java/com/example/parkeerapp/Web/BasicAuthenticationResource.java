package com.example.parkeerapp.web;

import com.example.parkeerapp.DTO.UserLoginDTO;
import com.example.parkeerapp.config.UserUserDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:3000")
public class BasicAuthenticationResource {

    private final UserUserDetailService userUserDetailService;

    public BasicAuthenticationResource(UserUserDetailService userUserDetailService){
        this.userUserDetailService = userUserDetailService;
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/user")
    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
    public UserDetails Authentication(@RequestBody UserLoginDTO userLoginDTO) throws Exception {
        UserDetails user = userUserDetailService.Login(userLoginDTO);
        return user;
    }


}