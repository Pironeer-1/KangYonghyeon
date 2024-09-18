package com.pironeer.week2_1.service;

import com.pironeer.week2_1.dto.request.CommentCreateRequest;
import com.pironeer.week2_1.repository.CommentRepository;
import com.pironeer.week2_1.repository.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        System.out.println(comment);

    }
}
