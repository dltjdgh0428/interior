package com.example.interior.web.dto.image;

import com.example.interior.model.image.Image;
import org.springframework.web.multipart.MultipartFile;


import lombok.Data;

@Data
public class ImageUploadDto {
    private MultipartFile file;
    private String caption;

    public Image toEntity(String postImageUrl) {
        return Image.builder()
                .caption(caption)
                .postImageUrl(postImageUrl)
                .build();
    }
}
