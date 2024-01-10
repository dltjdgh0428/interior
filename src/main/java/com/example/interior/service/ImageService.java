package com.example.interior.service;

import com.example.interior.model.image.Image;
import com.example.interior.model.image.ImageRepository;
import com.example.interior.web.dto.image.ImageUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Value("${file.path}")
    private String uploadFolder;

    @Transactional
    public void 사진업로드(ImageUploadDto imageUploadDto) {
        UUID uuid = UUID.randomUUID();
        String imageFileName = uuid + "_" + imageUploadDto.getFile().getOriginalFilename();
        System.out.println("이미지 파일이름:"+imageFileName);

        Path imageFilePath = Paths.get(uploadFolder + imageFileName);

        try {
            Files.write(imageFilePath, imageUploadDto.getFile().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Image image = imageUploadDto.toEntity(imageFileName);
        imageRepository.save(image);

    }

    @Transactional(readOnly = true)
    public List<Image> 인테리어사진(){
        return imageRepository.mExplore();
    }

    @Transactional
    public void 이미지삭제(int id) {
        imageRepository.deleteById(id);
    }
}
