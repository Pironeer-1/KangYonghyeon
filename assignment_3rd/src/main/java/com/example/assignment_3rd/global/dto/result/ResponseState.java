package com.example.assignment_3rd.global.dto.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
//생성자 자동 생성
public enum ResponseState {
    SUCCESS(1,"성공하였습니다"),

    FAIL(-1,"실패하였습니다");

    private int code;

    private String msg;
}
