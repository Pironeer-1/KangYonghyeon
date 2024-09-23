package com.pironeer.week2_1.dto.request;

import com.pironeer.week2_1.repository.domain.Comment;

public record ReplyCreateRequest(Comment comment,String content) {
}
