package com.example.interior.web;

import com.example.interior.config.auth.PrincipalDetails;
import com.example.interior.handler.ex.CustomValidationException;
import com.example.interior.service.CommentService;
import com.example.interior.service.ImageService;
import com.example.interior.web.dto.cover.CoverUploadDto;
import com.example.interior.web.dto.image.ImageUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ImageController {

    private final ImageService imageService;
    private final CommentService commentService;
    //커버사진
    @GetMapping({"/"})
    public String homePage(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        model.addAttribute("covers", imageService.커버사진());
        model.addAttribute("principal", principalDetails);
        model.addAttribute("comments",commentService.인사말());
        return "home";
    }

    @PostMapping("/")
    public String coverImageUpload(CoverUploadDto coverUploadDto) {
        //서비스 호출
        if(coverUploadDto.getFile().isEmpty()) {
            throw new CustomValidationException("이미지가 첨부되지 않았습니다.", null);
        }

        imageService.커버사진업로드(coverUploadDto);
        return "redirect:/"; // 여기 인테리어 페이지로 이동하게 할 것
    }
    //포트폴리오 사진
    @GetMapping("/image/upload")
    public String upload() {
        return "image/upload";
    }

    @PostMapping("/portfolio")
    public String imageUpload(ImageUploadDto imageUploadDto) {
        //서비스 호출
        if(imageUploadDto.getFile().isEmpty()) {
            throw new CustomValidationException("이미지가 첨부되지 않았습니다.", null);
        }

        imageService.사진업로드(imageUploadDto);
        return "redirect:/portfolio"; // 여기 인테리어 페이지로 이동하게 할 것
    }

    @GetMapping("/portfolio")
    public String explore(Model model,@AuthenticationPrincipal PrincipalDetails principalDetails) {
        model.addAttribute("images", imageService.인테리어사진());
        model.addAttribute("principal", principalDetails);
        return "image/portfolio";
    }

}
