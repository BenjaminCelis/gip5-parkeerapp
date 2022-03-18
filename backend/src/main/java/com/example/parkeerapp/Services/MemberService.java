package com.example.parkeerapp.Services;

import com.example.parkeerapp.Converter.MemberConverter;
import com.example.parkeerapp.DTO.CreateMemberDTO;
import com.example.parkeerapp.DTO.CreateUserDTO;
import com.example.parkeerapp.DTO.MemberDTO;
import com.example.parkeerapp.Domain.Member;
import com.example.parkeerapp.Domain.User;
import com.example.parkeerapp.dao.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MemberService {
    private final MemberRepository memberRepository;

    private final MemberConverter memberConverter;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public MemberService(MemberRepository memberRepository,MemberConverter memberConverter){
        this.memberRepository = memberRepository;
        this.memberConverter = memberConverter;

    }

    public MemberDTO createMember(CreateUserDTO createUserDTO){

        Member member = new Member();
        member.setUser(new User(createUserDTO.getFirstName(),createUserDTO.getLastName(),createUserDTO.getPassword(),"Member",createUserDTO.getEmail()));
        member.getUser().setUsername(createUserDTO.getEmail());
        member.getUser().setPassword(passwordEncoder.encode(member.getUser().getPassword()));
        memberRepository.save(member);
        return memberConverter.memberToDTO(member);
    }

    public List<MemberDTO> getAllMembers(){return memberConverter.MemberListToDTO(memberRepository.findAll());}

}



