package com.example.interior.web.dto.image;

import com.example.interior.model.album.Album;
import com.example.interior.model.image.Image;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ImageUploadDto {
    private MultipartFile file;

    public Image toEntity(String postImageUrl, Album album) {
        return Image.builder()
                .postImageUrl(postImageUrl)
                .album(album)
                .build();
    }
}
