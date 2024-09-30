package com.example.assignment_3rd.member.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long id;
    private String name;
    private String password;

    @Builder
    public Member(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
