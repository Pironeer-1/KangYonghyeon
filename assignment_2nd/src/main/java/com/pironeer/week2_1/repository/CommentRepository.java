package com.pironeer.week2_1.repository;

import com.pironeer.week2_1.repository.domain.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CommentRepository {
    private final AtomicLong commentIdxGenerator = new AtomicLong(1);
    private final Map<Long, Comment> commentMap=new HashMap<>();

    //일단 comment의 id를 고유로 만들고 객체 생성하면서 topic이랑 연결 하면될듯..?
    public void save(Comment comment) {
        //일단 예외 처리는 나중에
        //수정 구현시 이미 존재하면 대체하기
        if (comment.getId() == null) {
            long id = commentIdxGenerator.getAndIncrement();
            comment.setId(id);
            commentMap.put(id, comment);
        }
        //단건 업데이트
        else{
            commentMap.replace(comment.getId(), comment);
        }
    }

    //단건 조회
    public Optional<Comment> findById(Long id) {
        return Optional.of(commentMap.get(id));
        //NullpointException을 해결하기 위해서 OPtional로 감싼다
    }
    //전체 조회
    public List<Comment> findAll() {
        return commentMap.values().stream().toList();
    }
    //삭제
    public void deleteById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        commentMap.remove(id);
    }
    //Assert.notNull(id, "ID MUST NOT BE NULL");는 Spring Framework에서 제공하는 유틸리티 메서드로, 주어진 객체가 null이 아닌지 검증할 때 사용됩니다
    //Assert.notNul;(원하는 객체 ,null일시 예외 발생시 던질 메세지


}
