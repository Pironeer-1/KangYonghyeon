package com.pironeer.week2_1.repository.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long id;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    //foreign key-> 일단 객체 자체로 하기
    private Topic topic;

    @Builder
    public Comment(Long id, String content, LocalDateTime createAt, LocalDateTime updateAt, Topic topic) {
        this.id = id;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.topic = topic;
    }
}
