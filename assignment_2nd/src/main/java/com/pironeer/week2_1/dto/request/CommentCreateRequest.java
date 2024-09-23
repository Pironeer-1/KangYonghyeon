package com.pironeer.week2_1.dto.request;

import com.pironeer.week2_1.repository.domain.Topic;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CommentCreateRequest(
        @NotBlank
        @Schema(description = "게시물")
        Topic topic,
        @Schema(description = "댓글 내용", example = "내용입니다.")
        String content) {


}
