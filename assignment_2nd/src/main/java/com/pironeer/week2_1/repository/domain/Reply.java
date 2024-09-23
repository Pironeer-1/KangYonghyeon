package com.pironeer.week2_1.repository.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Reply {
    private Long id;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Comment comment;

    @Builder
    public Reply(Long id, String content, LocalDateTime createTime, LocalDateTime updateTime, Comment comment) {
        this.id = id;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.comment = comment;
    }
}
