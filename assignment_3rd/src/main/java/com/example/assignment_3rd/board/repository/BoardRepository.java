package com.example.assignment_3rd.board.repository;

import com.example.assignment_3rd.board.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board create(Board board);
    Optional<Board> findById(int id);
    List<Board> findAll();
    Board update(Board board);
    Long delete(Long id);
}
