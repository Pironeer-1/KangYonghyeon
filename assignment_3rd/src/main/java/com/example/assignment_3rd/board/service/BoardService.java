package com.example.assignment_3rd.board.service;

import com.example.assignment_3rd.board.dto.request.BoardCreateReq;
import com.example.assignment_3rd.board.entity.Board;
import com.example.assignment_3rd.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board create(BoardCreateReq req) {
        Board savedBoard= Board.builder()
                .title(req.title())
                .content(req.content())
                .author(req.member())
                .createdAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();


    }
}
