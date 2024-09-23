package com.pironeer.week2_1.dto.response;

import com.pironeer.week2_1.repository.domain.Comment;
import com.pironeer.week2_1.repository.domain.Reply;

import java.time.LocalDateTime;

public record ReplyResponse(Long id, Comment comment, String content, LocalDateTime createAt, LocalDateTime updateAt) {
    public static ReplyResponse of(Reply reply) {
        return new ReplyResponse(reply.getId(),reply.getComment(),reply.getContent(),reply.getCreateTime(),reply.getUpdateTime());
    }
}
