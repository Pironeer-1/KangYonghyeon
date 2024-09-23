package com.example.assignment_3rd.board.entity;

import com.example.assignment_3rd.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Board {
    private int id;
    private String title;
    private String content;
    private Member author;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @Builder
    public Board(int id, String title, String content, Member author, LocalDateTime createdAt, LocalDateTime updateAt) {
       this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
}
