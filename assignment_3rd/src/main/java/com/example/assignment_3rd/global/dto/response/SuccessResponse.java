package com.example.assignment_3rd.global.dto.response;

import com.example.assignment_3rd.global.dto.result.ResponseState;
import io.swagger.v3.oas.annotations.media.Schema;

public class SuccessResponse<T> {

    @Schema(description = "성공여부", example = "true")
    private boolean success=true;
    @Schema(description = "상태코드", example = "0")
    private int code;
    @Schema(description = "응답메세지", example = "성공하였습니다")
    private String message;
    @Schema(description = "응답데이터")
    private T result;

    public SuccessResponse(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }
    //default가 true여서 성공여부는 의미 없음
    //일반적인 응답 객체 만들기
    public static <T> SuccessResponse<T> of(int code, String message, T data) {
        return new SuccessResponse<>(code,message,data);
    }
    //주로 사용할 응답 객체 만들기
    public static <T> SuccessResponse<T> ok(T data) {
        return of(ResponseState.SUCCESS.getCode(),ResponseState.SUCCESS.getMsg(),data);
    }

}
