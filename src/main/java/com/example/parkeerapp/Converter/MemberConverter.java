package com.example.parkeerapp.Converter;


import com.example.parkeerapp.DTO.CreateMemberDTO;
import com.example.parkeerapp.DTO.MemberDTO;
import com.example.parkeerapp.Domain.Member;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
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
    public List<MemberDTO> MemberListToDTO(List<Member> members){
        return members.stream().map(this::memberToDTO).collect(Collectors.toList());
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

    // createMemberDTO to member
    public Member createMemberDTOToMember(CreateMemberDTO createMemberDTO){
        Member member = new Member();
        member.setId(createMemberDTO.getId());
        member.setFirstname(createMemberDTO.getFirstname());
        member.setPassword(createMemberDTO.getPassword());
        return member;
    }
    //Member to DTO member
    public CreateMemberDTO MemberToCreateMemberDTO(Member member){
        CreateMemberDTO createMemberDTO = new CreateMemberDTO();
        createMemberDTO.setId(member.getId());
        createMemberDTO.setPassword(member.getPassword());
        return createMemberDTO;
    }

    public Set<MemberDTO> memberSetToDTO(Set<Member> members){
        return members.stream().map(this::memberToDTO).collect(Collectors.toSet());
    }

    public MemberSimpleDTO memberToSimpleDTO (Member member){
        MemberSimpleDTO memberSimpleDTO = new MemberSimpleDTO();
        memberSimpleDTO.setId(member.getId());
        return memberSimpleDTO;
    }

}
