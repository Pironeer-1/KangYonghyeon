package com.example.assignment_3rd.member.repository;

import com.example.assignment_3rd.member.entity.Member;

public interface MemberRepository {
    Member save(Member member);
    Member findByName(String name);
    //존재 하는지 검사-> jwt에서 추가

}
