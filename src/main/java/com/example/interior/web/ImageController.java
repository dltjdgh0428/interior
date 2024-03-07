package com.example.interior.web;

import com.example.interior.config.auth.PrincipalDetails;
import com.example.interior.handler.ex.CustomValidationException;
import com.example.interior.model.album.Album;
import com.example.interior.model.image.Image;
import com.example.interior.service.AlbumService;
import com.example.interior.service.CommentService;
import com.example.interior.service.ImageService;
import com.example.interior.web.dto.album.AlbumUploadDto;
import com.example.interior.web.dto.cover.CoverUploadDto;
import com.example.interior.web.dto.image.ImageUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ImageController {

    private final ImageService imageService;
    private final CommentService commentService;
    private final AlbumService albumService;
    //커버사진
    @GetMapping({"/"})
    public String homePage(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        model.addAttribute("covers", imageService.커버사진());
        model.addAttribute("principal", principalDetails);
        model.addAttribute("comments",commentService.인사말());

        return "home";
    }
    @GetMapping("/portfolio")
    public String explore(Model model,@AuthenticationPrincipal PrincipalDetails principalDetails) {
        model.addAttribute("albums", albumService.전체앨범());
        model.addAttribute("principal", principalDetails);
        return "image/portfolio";
    }
    @GetMapping("/album/{id}")
    public String album(@PathVariable int id ,Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        model.addAttribute("album", albumService.앨범찾기(id));
        model.addAttribute("principal", principalDetails);
        return "image/album";
    }
    @PostMapping("/")
    public String coverImageUpload(CoverUploadDto coverUploadDto) throws IOException {
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
    public String imageUpload(AlbumUploadDto albumUploadDto) throws IOException {
        //서비스 호출
        Album albumEntity = albumUploadDto.toEntity(albumUploadDto.getCaption());
        List<Image> images = new ArrayList<>();
        albumService.앨범업로드(albumEntity); // 앨범 저장

        for (MultipartFile file : albumUploadDto.getFiles()) {
            ImageUploadDto imageUploadDto = new ImageUploadDto();
            imageUploadDto.setFile(file); // 각 파일을 ImageUploadDto에 설정
            String imageUrl = imageService.사진업로드(imageUploadDto, albumEntity);
            Image image = new Image();
            image.setPostImageUrl(imageUrl);
            image.setAlbum(albumEntity); // 이미지에 앨범 설정
            images.add(image);
        }
        albumEntity.setCaption(albumUploadDto.getCaption());
        albumEntity.setImages(images);

        albumService.앨범업로드(albumEntity); // 앨범 재저장

        return "redirect:/portfolio";
    }

}
