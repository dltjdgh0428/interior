package com.example.interior.web.dto.album;

import com.example.interior.model.album.Album;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class AlbumUploadDto {
    private List<MultipartFile> files;
    private String caption;

    public Album toEntity(String caption){
        return Album.builder()
                .caption(caption)
                .build();
    }
}
