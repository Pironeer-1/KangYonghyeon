package com.pironeer.week2_1.dto.request;

import com.pironeer.week2_1.repository.domain.Topic;
//일단 topic으로 연결해보고 나중에 id로도 바꿔보기
public record CommentCreateRequest(Topic topic, String content) {
// topic이 하나 들어오네 good!
}
