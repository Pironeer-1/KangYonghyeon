package com.example.assignment_3rd.board.service;

import com.example.assignment_3rd.board.dto.request.BoardCreateReq;
import com.example.assignment_3rd.board.dto.request.BoardUpdateReq;
import com.example.assignment_3rd.board.dto.response.BoardRes;
import com.example.assignment_3rd.board.entity.Board;
import com.example.assignment_3rd.board.repository.BoardRepository;
import com.example.assignment_3rd.global.dto.result.ListResult;
import com.example.assignment_3rd.global.dto.result.SingleResult;
import com.example.assignment_3rd.global.exception.CustomException;
import com.example.assignment_3rd.global.exception.ErrorCode;
import com.example.assignment_3rd.global.service.ResponseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public SingleResult<BoardRes> create(BoardCreateReq req) {
        Board reqBoard= Board.builder()
                .title(req.title())
                .content(req.content())
                .author(req.member())
                .createdAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();
        Board savedBoard=boardRepository.create(reqBoard);
        //res에 담아서
        BoardRes boardRes=BoardRes.of(savedBoard);
        return ResponseService.getSingeResult(boardRes);
    }

    //전체 조회
    public ListResult<BoardRes> findAll() {
        List<Board> boards=boardRepository.findAll();
        List<BoardRes> list=boards.stream().map(BoardRes::of).toList();
        return ResponseService.getListResult(list);
    }

    //단건 조회
    public SingleResult<BoardRes> findById(Long boardId) {
        Board board=boardRepository.findById(boardId).orElseThrow(()->new CustomException(ErrorCode.BOARD_NOT_FOUND));
        BoardRes boardRes=BoardRes.of(board);
        return ResponseService.getSingeResult(boardRes);
    }

    //단건 삭제
    public SingleResult<Long> deleteById(Long boardId) {
        Long deletedId=boardRepository.deleteById(boardId);
        return ResponseService.getSingeResult(deletedId);
    }
    //업데이트
    public SingleResult<Long> update(BoardUpdateReq req) {
        Board board=boardRepository.findById(req.id()).orElseThrow(()->new CustomException(ErrorCode.BOARD_NOT_FOUND));
        boardRepository.create(board.update(req));
        return ResponseService.getSingeResult(board.getId());
    }
}
