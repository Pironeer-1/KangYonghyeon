package com.pironeer.week2_1.dto.response;

import com.pironeer.week2_1.repository.domain.Comment;
import com.pironeer.week2_1.repository.domain.Topic;

import java.time.LocalDateTime;

public record CommentResponse(Long id, Topic topic, String comment, LocalDateTime createdAt,LocalDateTime updatedAt) {
    public static CommentResponse of(Comment comment) {
        return new CommentResponse(comment.getId(),comment.getTopic(),comment.getContent(),comment.getCreateAt(),comment.getUpdateAt());
    }
}
