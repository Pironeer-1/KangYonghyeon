package com.pironeer.week2_1.repository;

import com.pironeer.week2_1.repository.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CommentRepository {
    private final AtomicLong commentIdxGenerator = new AtomicLong(1);
    private final Map<Long, Comment> commentMap=new HashMap<>();

    //일단 comment의 id를 고유로 만들고 객체 생성하면서 topic이랑 연결 하면될듯..?
    public void save(Comment comment) {
        //일단 예외 처리는 나중에
        long id = commentIdxGenerator.getAndIncrement();
        comment.setId(id);
        commentMap.put(id, comment);
    }

    //단건 조회
    public Comment findById(Long id) {
        return commentMap.get(id);
    }

}
