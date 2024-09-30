package com.example.assignment_3rd.member.repository;

import com.example.assignment_3rd.member.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemberMemoryRepository implements MemberRepository {
    AtomicLong memberIdx= new AtomicLong(0);
    Map<Long,Member> memberMap=new HashMap<>();

    @Override
    public Member save(Member member) {
        Long id=memberIdx.getAndIncrement();
        member.setId(id);
        memberMap.put(id,member);
        return member;
    }
    @Override
    public Optional<Member> findByName(String name){
        return memberMap.values().stream().filter(m->m.getName().equals(name)).findAny();
    }
    @Override
    public Boolean existsByName(String name) {
        return memberMap.values().stream()
                .anyMatch(data->data.getName().equals(name));
    }


}
