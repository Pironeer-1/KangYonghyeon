package com.example.assignment_3rd.member.service;

import com.example.assignment_3rd.global.dto.result.SingleResult;
import com.example.assignment_3rd.global.service.ResponseService;
import com.example.assignment_3rd.member.dto.request.MemberJoinReq;
import com.example.assignment_3rd.member.entity.Member;
import com.example.assignment_3rd.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    //회원가입
    public SingleResult<Member> join(MemberJoinReq req) {
        Member member=Member.builder()
                .name(req.name())
                .password(req.password())
                .build();
        Member savedMember=memberRepository.save(member);
        return ResponseService.getSingeResult(savedMember);
    }
}
