package com.example.interior.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.interior.model.album.Album;
import com.example.interior.model.album.AlbumRepository;
import com.example.interior.model.cover.Cover;
import com.example.interior.model.cover.CoverRepository;
import com.example.interior.model.image.Image;
import com.example.interior.model.image.ImageRepository;
import com.example.interior.web.dto.album.AlbumUploadDto;
import com.example.interior.web.dto.cover.CoverUploadDto;
import com.example.interior.web.dto.image.ImageUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private final CoverRepository coverRepository;

    private final AmazonS3 amazonS3;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    @Value("${file.path}")
    private String uploadFolder;

    @Transactional
    public String 사진업로드(ImageUploadDto imageUploadDto, Album album) {
        UUID uuid = UUID.randomUUID();
        String imageFileName = uuid + "_" + imageUploadDto.getFile().getOriginalFilename();
        System.out.println("이미지 파일이름:"+imageFileName);

        Path imageFilePath = Paths.get(uploadFolder + imageFileName);

        try {
            Files.write(imageFilePath, imageUploadDto.getFile().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Image image = imageUploadDto.toEntity(imageFileName,album);
        imageRepository.save(image);
        return imageFileName;
    }
    ///S3버킷 테스트용
    @Transactional
    public String 커버사진업로드(CoverUploadDto coverUploadDto) throws IOException {
        UUID uuid = UUID.randomUUID();
        String imageFileName = uuid + "_" + coverUploadDto.getFile().getOriginalFilename();
        System.out.println("커버 이미지 파일이름:"+imageFileName);

        Path imageFilePath = Paths.get(uploadFolder + imageFileName);

        try {
            Files.write(imageFilePath, coverUploadDto.getFile().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        MultipartFile multipartFile = coverUploadDto.getFile();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(multipartFile.getSize());
        metadata.setContentType(multipartFile.getContentType());


        Cover cover = coverUploadDto.toEntity(imageFileName);
        coverRepository.save(cover);

        amazonS3.putObject(bucket, imageFileName, multipartFile.getInputStream(), metadata);
        return amazonS3.getUrl(bucket, imageFileName).toString();
    }

    @Transactional(readOnly = true)
    public List<Image> 인테리어사진(){
        return imageRepository.mExplore();
    }

    @Transactional(readOnly = true)
    public List<Cover> 커버사진(){
        return coverRepository.mExplore();
    }

    @Transactional
    public void 이미지삭제(int id) {
        imageRepository.deleteById(id);
    }
    @Transactional
    public void 커버이미지삭제(int id) {
        coverRepository.deleteById(id);
    }


}
