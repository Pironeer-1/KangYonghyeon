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

    public void save(Comment comment) {
        if (comment.getId() == null) {
            long id = commentIdxGenerator.getAndIncrement();
            comment.setId(id);
            commentMap.put(id, comment);
        }
        else{
            commentMap.replace(comment.getId(), comment);
        }
    }

    public Optional<Comment> findById(Long id) {
        return Optional.of(commentMap.get(id));
    }

    public List<Comment> findAll() {
        return commentMap.values().stream().toList();
    }

    public void deleteById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        commentMap.remove(id);
    }
}
