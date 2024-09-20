package com.pironeer.week2_1.service;

import com.pironeer.week2_1.dto.request.ReplyCreateRequest;
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
    //레포 생성
    private final ReplyRepository replyRepository;
    //저장 함수
    public void save(ReplyCreateRequest request) {
        //기본적으로 서비스에서 rq에있는데이터를 빼서 객체를 만들고 넘긴다.
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

}
