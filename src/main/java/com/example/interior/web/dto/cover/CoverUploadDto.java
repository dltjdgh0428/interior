package com.example.interior.web.dto.cover;

import com.example.interior.model.cover.Cover;
import com.example.interior.model.image.Image;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CoverUploadDto {
    private MultipartFile file;
    private String title;

    public Cover toEntity(String coverImageUrl) {
        return Cover.builder()
                .coverImageUrl(coverImageUrl)
                .title(title)
                .build();
    }
}
