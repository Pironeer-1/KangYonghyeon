package com.pironeer.week2_1.controller;

import com.pironeer.week2_1.dto.request.CommentCreateRequest;
import com.pironeer.week2_1.dto.response.CommentResponse;
import com.pironeer.week2_1.repository.domain.Comment;
import com.pironeer.week2_1.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@operation 이랑 tag는 swagger문서 꾸밀때 사용
//@schema도
//@vaild또한 나중에 유효성 체크로 미루기 일단 코드부터 구현
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
    //서비스 선언
    private final CommentService commentService;
    //댓글 작성
    //ResopnseEntity를 리턴하는 함수
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CommentCreateRequest request){
        //요청 받아서 저장
        commentService.save(request);
        return ResponseEntity.ok().build();
    }
    //댓글 단건조회..?필요 한가..?
    @GetMapping("{commentId}")
    public ResponseEntity<CommentResponse> read(@PathVariable ("commentId")Long id){
        CommentResponse commentResponse=commentService.findById(id);
        return ResponseEntity.ok().body(commentResponse);
    }
    //@pathVariable-> URL경로에서 변수를 가져오는데 사용 ex)comment/4 가 들어면 id에 4에 할당
    //전체 조회
    @GetMapping
    public ResponseEntity<List<CommentResponse>> readAll(){
        List<CommentResponse> responses=commentService.findAll();
        return ResponseEntity.ok().body(responses);
    }

}
