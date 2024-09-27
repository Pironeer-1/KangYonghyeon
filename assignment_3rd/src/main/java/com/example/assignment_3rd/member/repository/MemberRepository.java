package com.example.assignment_3rd.member.repository;

import com.example.assignment_3rd.member.entity.Member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByName(String name);
    //존재 하는지 검사-> jwt에서 추가
    //아이디 중복 체크
    Boolean existsByName(String name);

}
