package com.example.assignment_3rd.member.service;

import com.example.assignment_3rd.global.dto.result.SingleResult;
import com.example.assignment_3rd.global.service.ResponseService;
import com.example.assignment_3rd.member.dto.request.MemberJoinReq;
import com.example.assignment_3rd.member.dto.request.MemberLoginReq;
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

    //로그인
    public SingleResult<Long> login(MemberLoginReq req)  {
        Member loginMember=memberRepository.findByName(req.name()).orElseThrow(()->(new RuntimeException("USER_NOT_EXIST")));
        //비밀번호 검증
        if (!loginMember.getPassword().equals(req.password())) {
            throw new RuntimeException("PASSWORD_WRONG");
        }
        return ResponseService.getSingeResult(loginMember.getId());
    }
}
