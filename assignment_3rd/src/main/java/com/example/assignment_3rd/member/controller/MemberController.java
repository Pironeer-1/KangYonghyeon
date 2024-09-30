package com.example.assignment_3rd.member.controller;

import com.example.assignment_3rd.global.dto.response.SuccessResponse;
import com.example.assignment_3rd.global.dto.result.SingleResult;
import com.example.assignment_3rd.member.dto.request.MemberJoinReq;
import com.example.assignment_3rd.member.dto.request.MemberLoginReq;
import com.example.assignment_3rd.member.entity.Member;
import com.example.assignment_3rd.member.service.MemberService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Member")
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    //회원 가입-> 일단 구현 하고 jwt 추가하기
    @PostMapping("/join")
    public SuccessResponse<SingleResult<Member>> join(MemberJoinReq req){
        SingleResult<Member> result=memberService.join(req);
        return SuccessResponse.ok(result);
    }
    @PostMapping("/login")
    public SuccessResponse<SingleResult<Long>> login (MemberLoginReq req){
        SingleResult<Long> result=memberService.login(req);
        return SuccessResponse.ok(result);
    }

}
