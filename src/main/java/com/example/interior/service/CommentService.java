package com.example.interior.service;

import com.example.interior.model.comment.Comment;
import com.example.interior.model.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    @Transactional
    public Comment 인사말쓰기(String content) {

        // Save할 때 연관관계가 있으면 오브젝트로 만들어서 id값만 넣어주면 된다.
        Comment comment = Comment.builder()
                .content(content)
                .build();

        return commentRepository.save(comment);
    }

    @Transactional
    public void 인사말삭제(int id) {
        commentRepository.deleteById(id);
    }
}
