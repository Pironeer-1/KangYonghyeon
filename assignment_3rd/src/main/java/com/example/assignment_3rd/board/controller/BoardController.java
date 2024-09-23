package com.example.assignment_3rd.board.controller;

import com.example.assignment_3rd.board.dto.request.BoardCreateReq;
import com.example.assignment_3rd.board.dto.request.BoardUpdateReq;
import com.example.assignment_3rd.board.dto.response.BoardRes;
import com.example.assignment_3rd.board.entity.Board;
import com.example.assignment_3rd.board.service.BoardService;
import com.example.assignment_3rd.global.dto.response.SuccessResponse;
import com.example.assignment_3rd.global.dto.result.ListResult;
import com.example.assignment_3rd.global.dto.result.SingleResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //전체 조회
    @GetMapping
    @Operation(summary = "게시물 전체 조회")
    public SuccessResponse<ListResult<BoardRes>> findAll(){
        ListResult<BoardRes> result=boardService.findAll();
        return SuccessResponse.ok(result);
    }
    //id로 조회
    @GetMapping("/{boardId}")
    @Operation(summary = "게시물 단건 조회")
    public SuccessResponse<SingleResult<BoardRes>> findById(@PathVariable ("boardId")Long boardId){
        SingleResult<BoardRes> result=boardService.findById(boardId);
        return SuccessResponse.ok(result);
    }
    //단건 삭제
    @DeleteMapping("/{boardId}")
    @Operation(summary = "게시물 삭제")
    public SuccessResponse<SingleResult<Long>> delete(@PathVariable ("boardId")Long boardId){
        SingleResult<Long> result=boardService.deleteById(boardId);
        return SuccessResponse.ok(result);
    }
    //update
    @PutMapping
    @Operation(summary = "게시물 업데이트")
    public SuccessResponse<SingleResult<Long>> update(@Valid @RequestBody BoardUpdateReq req){
        SingleResult<Long> result=boardService.update(req);
        return SuccessResponse.ok(result);
    }

}
