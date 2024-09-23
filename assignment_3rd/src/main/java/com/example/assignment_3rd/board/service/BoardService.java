package com.example.assignment_3rd.board.service;

import com.example.assignment_3rd.board.dto.request.BoardCreateReq;
import com.example.assignment_3rd.board.entity.Board;
import com.example.assignment_3rd.board.repository.BoardRepository;
import com.example.assignment_3rd.global.dto.result.SingleResult;
import com.example.assignment_3rd.global.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public SingleResult<Board> create(BoardCreateReq req) {
        Board reqBoard= Board.builder()
                .title(req.title())
                .content(req.content())
                .author(req.member())
                .createdAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();
        Board savedBoard=boardRepository.create(reqBoard);
        return ResponseService.getSingeResult(savedBoard);
    }
}
