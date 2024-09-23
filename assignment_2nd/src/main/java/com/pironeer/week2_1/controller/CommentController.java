package com.pironeer.week2_1.controller;

import com.pironeer.week2_1.dto.request.CommentCreateRequest;
import com.pironeer.week2_1.dto.request.CommentUpdateRequest;
import com.pironeer.week2_1.dto.response.CommentResponse;
import com.pironeer.week2_1.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
@Tag(name = "댓글(Comment)")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @Operation(summary = "댓글 작성")
    public ResponseEntity<?> create(@RequestBody CommentCreateRequest request){
        commentService.save(request);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{commentId}")
    @Operation(summary = "댓글 단건 조회")
    public ResponseEntity<CommentResponse> read(@PathVariable ("commentId")Long id){
        CommentResponse commentResponse=commentService.findById(id);
        return ResponseEntity.ok().body(commentResponse);
    }
    @GetMapping
    @Operation(summary = "댓글 전체 조회")
    public ResponseEntity<List<CommentResponse>> readAll(){
        List<CommentResponse> responses=commentService.findAll();
        return ResponseEntity.ok().body(responses);
    }
    @PutMapping
    @Operation(summary = "댓글 수정")
    public ResponseEntity<CommentResponse> update(@RequestBody CommentUpdateRequest request){
        CommentResponse response =commentService.update(request);
        return ResponseEntity.ok().body(response);
    }
    @DeleteMapping("/{commentId}")
    @Operation(summary = "댓글 삭제")
    public ResponseEntity<?> remove(@PathVariable ("commentId")Long id){
        commentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
