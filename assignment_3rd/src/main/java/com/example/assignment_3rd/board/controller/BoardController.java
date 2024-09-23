package com.example.assignment_3rd.board.controller;

import com.example.assignment_3rd.board.dto.request.BoardCreateReq;
import com.example.assignment_3rd.board.dto.response.BoardRes;
import com.example.assignment_3rd.board.entity.Board;
import com.example.assignment_3rd.board.service.BoardService;
import com.example.assignment_3rd.global.dto.response.SuccessResponse;
import com.example.assignment_3rd.global.dto.result.SingleResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
@Tag(name = "Board")
public class BoardController {
    //service 생성
    private final BoardService boardService;

    //게시글 생성
    @PostMapping
    @Operation(summary = "게시물 작성")
    public SuccessResponse<SingleResult<BoardRes>> create(@Valid @RequestBody BoardCreateReq req){
        SingleResult<BoardRes> save = boardService.create(req);
        return SuccessResponse.ok(save);
    }
    //전체

}
