package com.pironeer.week2_1.service;

import com.pironeer.week2_1.dto.request.CommentCreateRequest;
import com.pironeer.week2_1.dto.request.CommentUpdateRequest;
import com.pironeer.week2_1.dto.response.CommentResponse;
import com.pironeer.week2_1.repository.CommentRepository;
import com.pironeer.week2_1.repository.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void save(CommentCreateRequest request){
        Comment comment=Comment.builder()
                                .content(request.content())
                                .createAt(LocalDateTime.now())
                                .updateAt(LocalDateTime.now())
                                .topic(request.topic())
                                .build();
        commentRepository.save(comment);
    }

    public CommentResponse findById(Long id) {
        Comment comment=commentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Comment not found"));
        return CommentResponse.of(comment);
    }

    public List<CommentResponse> findAll() {
        List<Comment> comments=commentRepository.findAll();
        return comments.stream().map(CommentResponse::of).toList();
    }

    public CommentResponse update(CommentUpdateRequest request) {
        Comment comment=commentRepository.findById(request.id())
                .orElseThrow(()-> new RuntimeException("Comment not found"));
        updateContent(request.content(),comment);
        comment.setUpdateAt(LocalDateTime.now());
        commentRepository.save(comment);
        return CommentResponse.of(comment);
    }

    private static void updateContent(String content,Comment comment){
        if(content!=null&& !content.isBlank()){
            comment.setContent(content);
        }
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
