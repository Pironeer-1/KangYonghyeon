package com.example.assignment_3rd.board.dto.response;

import com.example.assignment_3rd.board.entity.Board;
import com.example.assignment_3rd.member.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BoardRes(
    @Schema(description = "게시물 ID", example = "1")
    Long id,
    @Schema(description = "게시물 제목", example = "제목입니다")
    String title,
    @Schema(description = "게시물 내용", example = "내용입니다")
    String content,
    @Schema(description = "작성자")
    Member author,
    @Schema(description = "게시물 생성 시간", example = "2024-10-10 10:10:00")
    LocalDateTime createdAt,
    @Schema(description = "게시물 수정시간", example = "2024-10-13 10:10:00")
    LocalDateTime updatedAt
) {
    public static BoardRes of(Board board) {
        return BoardRes.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .author(board.getAuthor())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdateAt())
                .build();
    }
}
