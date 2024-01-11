package com.example.interior.web.api;

import com.example.interior.model.comment.CommentRepository;
import com.example.interior.service.CommentService;
import com.example.interior.web.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentService commentService;

    @DeleteMapping("/api/comment/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        commentService.인사말삭제(id);
        return new ResponseEntity<>(new CMRespDto<>(1, "인사말삭제성공", null), HttpStatus.OK);
    }
}
