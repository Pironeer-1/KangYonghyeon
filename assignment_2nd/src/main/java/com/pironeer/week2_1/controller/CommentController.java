package com.pironeer.week2_1.controller;

import com.pironeer.week2_1.dto.request.CommentCreateRequest;
import com.pironeer.week2_1.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@operation 이랑 tag는 swagger문서 꾸밀때 사용
//@schema도
//@vaild또한 나중에 유효성 체크로 미루기 일단 코드부터 구현
@RestController
@RequestMapping("/api/comment")
public class CommentController {
    //서비스 선언
    private CommentService commentService;
    //댓글 작성
    //ResopnseEntity를 리턴하는 함수
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CommentCreateRequest request){
        //요청 받아서 저장
        commentService.save(request);
        return ResponseEntity.ok().build();
    }


}
