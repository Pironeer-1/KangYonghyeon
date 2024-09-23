package com.example.assignment_3rd.global.service;

import com.example.assignment_3rd.global.dto.result.ListResult;
import com.example.assignment_3rd.global.dto.result.SingleResult;

import java.util.List;

public class ResponseService {
    public static <T> SingleResult<T> getSingeResult(T data){
        SingleResult<T> result=new SingleResult<T>();
        //객체 생성후 data set으로 저장
        result.setData(data);
        return result;
    }
    public static <T> ListResult<T> getListResult(List<T> data){
        ListResult<T> result=new ListResult<>();
        result.setList(data);
        return result;
    }
}
