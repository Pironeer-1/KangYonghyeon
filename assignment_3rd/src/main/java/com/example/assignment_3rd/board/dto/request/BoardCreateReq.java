package com.example.assignment_3rd.board.dto.request;

import com.example.assignment_3rd.member.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record BoardCreateReq(
        @Schema(description = "제목", example = "게시물")
        String title,
        @Schema(description = "내용", example = "게시물 입니다")
        String content,
        @Schema(description = "author")
        Member member
) {
}
