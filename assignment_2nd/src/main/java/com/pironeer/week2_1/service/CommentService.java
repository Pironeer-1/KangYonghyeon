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
//알아서 생성-> 근데 이걸로 왜 private final CommentRepository commentRepository;이게 해결되는거지..?
//-> 아마 애노테이션으로 bean으로 자동으로 올리고 @RequiredArgsConstructor로 자동으로 연결해주는건가?
//@RequiredArgsConstructor:
//
//이 애너테이션은 클래스 내의 final 필드 또는 @NonNull 필드를 포함하는 생성자를 자동으로 만들어줍니다.
//따라서 private final CommentRepository commentRepository;처럼 final로 선언된 필드는 자동 생성된 생성자의 매개변수로 들어가며, 그에 맞는 생성자가 생기게 됩니다.
//이 과정에서 @RequiredArgsConstructor 애너테이션 덕분에 별도로 생성자를 작성할 필요 없이 Lombok이 생성자를 자동으로 만들어주기 때문에, Spring이 의존성을 주입할 수 있게 됩니다.
public class CommentService {
    //레포 생성
    private final CommentRepository commentRepository;
    //생성
    public void save(CommentCreateRequest request){
        Comment comment=Comment.builder()
                                .content(request.content())
                                .createAt(LocalDateTime.now())
                                .updateAt(LocalDateTime.now())
                                .topic(request.topic())
                                .build();
        //comment를만들고 레포에 저장
        commentRepository.save(comment);
    }
    //단건 조회
    public CommentResponse findById(Long id) {
        Comment comment=commentRepository.findById(id);
        return CommentResponse.of(comment);
        //여기서 새로 응답객체를 만들어서 넘김
    }

    public List<CommentResponse> findAll() {
        List<Comment> comments=commentRepository.findAll();
        return comments.stream().map(CommentResponse::of).toList();
        //eomment들은 map해서 각각 CommentResponse의 of 메서드에 넣고 돌린다음에 리스트로 만든다.
    }

    //업데이트
    public CommentResponse update(CommentUpdateRequest request) {
        Comment comment=commentRepository.findById(request.id())
                .orElseThrow(()-> new RuntimeException("Comment not found"));
        //optional값이 존재할시 값을 꺼내고 없을시 에러발생시 메세지를 던진다.
        //update dto을 하나더 만든다.
        //없으면 not found 예외처리 해주기
        //내용 업데이트
        updateContent(request.content(),comment);
        //시간 업데이트
        comment.setUpdateAt(LocalDateTime.now());
        commentRepository.save(comment);
        return CommentResponse.of(comment);
    }
    //업데이트 함수
    private static void updateContent(String content,Comment comment){
        if(content!=null&& !content.isBlank()){
            comment.setContent(content);
        }
    }
    //삭제 함수
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
