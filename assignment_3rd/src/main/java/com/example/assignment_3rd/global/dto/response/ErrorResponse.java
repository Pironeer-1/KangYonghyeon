package com.example.assignment_3rd.global.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class ErrorResponse<T> {
    @Schema(description = "성공여부",example = "false")
    private  boolean success=false;
    @Schema(description = "에러 코드",example = "-100")
    private int code;
    @Schema(description = "에러 메세지",example = "실패하였습니다")
    private String message;
    @Schema(description = "예외 참고 데이터")
    private T result;

    public ErrorResponse(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }
    //결과 값이 없을대
    public static <T> ErrorResponse<T> of(int code, String message) {
        return new ErrorResponse<>(code,message,null);
    }
    //예외 참고 데이터가 있을때
    public static <T> ErrorResponse<T> of(int code, String message, T data) {
        return new ErrorResponse<>(code,message,data);
    }
}
