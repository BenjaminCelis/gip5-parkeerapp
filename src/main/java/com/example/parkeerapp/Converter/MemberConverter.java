package com.example.parkeerapp.Converter;


import com.example.parkeerapp.DTO.MemberDTO;
import com.example.parkeerapp.Domain.Member;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberConverter {


    // Member to memberDTO
    public MemberDTO memberToDTO(Member member){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(member.getId());
        memberDTO.setEmail(member.getEmail());
        memberDTO.setFirstname(member.getFirstname());
        memberDTO.setLastname(member.getLastname());
        memberDTO.setRole(member.getRole());
        return memberDTO;
    }

    // Member list to MemberDTO list
    public List<MemberDTO> MemberListToDTO(List<Member> memberList){
        return memberList.stream().map(this::memberToDTO).collect(Collectors.toList());
    }

    // memberDTO to member
    public Member memberDTOtoMember(MemberDTO memberDTO){
        Member member = new Member();
        member.setEmail(memberDTO.getEmail());
        member.setFirstname(member.getFirstname());
        member.setLastname(member.getLastname());
        member.setRole(member.getRole());
        return member;
    }

    public MemberSimpleDTO memberSimpleDTO (Member member){
        MemberSimpleDTO memberSimpleDTO = new MemberSimpleDTO();
        memberSimpleDTO.set
        return memberSimpleDTO;
    }

}
