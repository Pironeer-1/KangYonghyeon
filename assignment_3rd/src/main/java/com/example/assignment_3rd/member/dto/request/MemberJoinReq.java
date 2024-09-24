package com.example.assignment_3rd.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;


public record MemberJoinReq(
        @Schema(description = "유저 이름", example = "강용현")
        String name,
        @Schema(description = "유저 비밀번호", example = "1234")
        String password

) {
}
