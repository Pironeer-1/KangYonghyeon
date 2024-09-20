package com.pironeer.week2_1.repository;

import com.pironeer.week2_1.repository.domain.Reply;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ReplyRepository {
    private final AtomicLong replyIdxGenerater = new AtomicLong(1);
    private final Map<Long,Reply> replyMap=new HashMap<>();
    //저장
    public void save(Reply reply) {
        if(reply.getId()==null){
            long id = replyIdxGenerater.incrementAndGet();
            reply.setId(id);
            replyMap.put(id,reply);
        }
        else {
            replyMap.replace(reply.getId(),reply);
        }

    }

    //전체 조회
    public List<Reply> findAll() {
        return replyMap.values().stream().toList();
    }
    //단건 조회
    public Optional<Reply> findById(Long id) {
        return Optional.of(replyMap.get(id));
        //optional 객체로 넘기기
    }

    public void deleteById(Long id) {
        Assert.notNull(id,"ID MUST NOT BE NULL");
        replyMap.remove(id);
    }
}
