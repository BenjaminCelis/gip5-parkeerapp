package com.example.parkeerapp.config;

import com.example.parkeerapp.Domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;

public class MemberPrincipal  {

    private final Member member;

    public MemberPrincipal(Member member){ this.member = member;}

    public Member getMember(){ return member;}

    //get role
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + member.getRole()));
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }
}
