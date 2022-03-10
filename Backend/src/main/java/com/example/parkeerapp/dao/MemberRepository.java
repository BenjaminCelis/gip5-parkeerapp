package com.example.parkeerapp.dao;

import com.example.parkeerapp.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MemberRepository extends JpaRepository <Member, Long> {
    Optional<Member> findByMember (Member member);

}
