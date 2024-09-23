package com.example.assignment_3rd.board.repository;

import com.example.assignment_3rd.board.entity.Board;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BoardMemoryRepository implements BoardRepository {

    private AtomicLong boaerIdx = new AtomicLong(0);
    private Map<Long,Board> boardMap = new HashMap<>();

    @Override
    public Board create(Board board) {
        return null;
    }

    @Override
    public Optional<Board> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Board> findAll() {
        return List.of();
    }

    @Override
    public Board update(Board board) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return id;
    }
}
