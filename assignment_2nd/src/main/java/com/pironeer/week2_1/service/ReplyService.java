package com.pironeer.week2_1.service;

import com.pironeer.week2_1.dto.request.ReplyCreateRequest;
import com.pironeer.week2_1.dto.request.ReplyUpdateRequest;
import com.pironeer.week2_1.dto.response.ReplyResponse;
import com.pironeer.week2_1.repository.ReplyRepository;
import com.pironeer.week2_1.repository.domain.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    public void save(ReplyCreateRequest request) {
        Reply reply= Reply.builder()
                .content(request.content())
                .comment(request.comment())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        replyRepository.save(reply);
    }
    //전체 조회
    public List<ReplyResponse> findAll() {
        List<Reply> replies=replyRepository.findAll();
        return replies.stream().map(ReplyResponse::of).toList();
    }


    public ReplyResponse findById(Long id) {
        Reply reply =replyRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Reply not found"));
        return ReplyResponse.of(reply);
    }

    public ReplyResponse update(ReplyUpdateRequest request) {
        Reply reply=replyRepository.findById(request.id())
                .orElseThrow(()-> new RuntimeException("Reply not found"));
        updateContent(request.content(), reply);
        reply.setUpdateTime(LocalDateTime.now());
        replyRepository.save(reply);
        return ReplyResponse.of(reply);
    }
    private void updateContent(String content,Reply reply) {
        if(content!=null&&!content.isBlank()) {
            reply.setContent(content);
        }
    }

    public void deleteById(Long id) {
        replyRepository.deleteById(id);
    }
}
