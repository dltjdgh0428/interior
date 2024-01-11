package com.example.interior.service;

import com.example.interior.model.comment.Comment;
import com.example.interior.model.comment.CommentRepository;
import com.example.interior.model.cover.Cover;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    @Transactional
    public Comment 인사말쓰기(String content) {

        Comment comment = Comment.builder()
                .content(content)
                .build();

        return commentRepository.save(comment);
    }

    @Transactional(readOnly = true)
    public List<Comment> 인사말(){
        return commentRepository.mExplore();
    }
    @Transactional
    public void 인사말삭제(int id) {
        commentRepository.deleteById(id);
    }
}
