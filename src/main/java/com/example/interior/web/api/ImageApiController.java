package com.example.interior.web.api;

import com.example.interior.model.image.Image;
import com.example.interior.service.ImageService;
import com.example.interior.web.dto.CMRespDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ImageApiController {

    private final ImageService imageService;

    @DeleteMapping("/api/portfolio/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        imageService.이미지삭제(id);
        return new ResponseEntity<>(new CMRespDto<>(1, "이미지삭제성공", null), HttpStatus.OK);
    }

    @DeleteMapping("/api/cover/{id}")
    public ResponseEntity<?> deleteCoverById(@PathVariable int id){
        imageService.커버이미지삭제(id);
        return new ResponseEntity<>(new CMRespDto<>(1, "커버이미지삭제성공", null), HttpStatus.OK);
    }
}
