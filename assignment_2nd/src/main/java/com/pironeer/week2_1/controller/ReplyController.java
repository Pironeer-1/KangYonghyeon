package com.pironeer.week2_1.controller;

import com.pironeer.week2_1.dto.request.ReplyCreateRequest;
import com.pironeer.week2_1.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reply")
public class ReplyController {
    //서비스 생성
    private final ReplyService replyService;
    //대댓글 생성
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ReplyCreateRequest request){
        replyService.save(request);
        return ResponseEntity.ok().build();
    }
}
