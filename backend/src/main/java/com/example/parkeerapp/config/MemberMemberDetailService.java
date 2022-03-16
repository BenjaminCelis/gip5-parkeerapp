package com.example.parkeerapp.config;


import com.example.parkeerapp.dao.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("MemberDetailService")
public class MemberMemberDetailService {

    private final MemberRepository memberRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public MemberMemberDetailService


}
