package com.pironeer.week2_1.repository;

import com.pironeer.week2_1.repository.domain.Reply;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ReplyRepository {
    private final AtomicLong replyIdxGenerater = new AtomicLong(1);
    private final Map<Long,Reply> replyMap=new HashMap<>();
    //저장
    public void save(Reply reply) {
        long id = replyIdxGenerater.incrementAndGet();
        reply.setId(id);
        replyMap.put(id,reply);
    }
}
