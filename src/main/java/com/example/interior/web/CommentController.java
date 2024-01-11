package com.example.interior.web;

import com.example.interior.handler.ex.CustomValidationException;
import com.example.interior.service.CommentService;
import com.example.interior.web.dto.cover.CoverUploadDto;
import com.example.interior.web.dto.image.ImageUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment")
    public String commentUpload(String comment) {
        commentService.인사말쓰기(comment);
        return "redirect:/"; // 여기 인테리어 페이지로 이동하게 할 것
    }
}
