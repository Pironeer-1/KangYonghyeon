package com.pironeer.week2_1.controller;

import com.pironeer.week2_1.dto.request.ReplyCreateRequest;
import com.pironeer.week2_1.dto.request.ReplyUpdateRequest;
import com.pironeer.week2_1.dto.response.ReplyResponse;
import com.pironeer.week2_1.service.ReplyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reply")
@Tag(name="대댓글(Reply)")
public class ReplyController {
    //서비스 생성
    private final ReplyService replyService;
    //대댓글 생성
    @PostMapping
    @Operation(summary = "대댓글 작성")
    public ResponseEntity<?> create(@RequestBody ReplyCreateRequest request){
        replyService.save(request);
        return ResponseEntity.ok().build();
    }
    //전체 조회
    @GetMapping
    @Operation(summary = "대댓글 전체 조회")
    public ResponseEntity<List<ReplyResponse>> readAll(){
        List<ReplyResponse> responses =replyService.findAll();
        return ResponseEntity.ok().body(responses);
    }
    //단건 조회
    @GetMapping("/{replyId}")
    @Operation(summary = "대댓글 단건 조회")
    public ResponseEntity<ReplyResponse> read(@PathVariable ("replyId")Long id){
        ReplyResponse replyResponse= replyService.findById(id);
        return ResponseEntity.ok().body(replyResponse);
    }
    //업데이트
    @PutMapping
    @Operation(summary = "대댓글 수정")
    public ResponseEntity<ReplyResponse> update(@RequestBody ReplyUpdateRequest request){
        replyService.update(request);
        return ResponseEntity.ok().build();
    }
    //삭제 구현
    @DeleteMapping("/{replyId}")
    @Operation(summary = "대댓글 삭제")
    public ResponseEntity<?> remove(@PathVariable("replyId") Long id){
        replyService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
