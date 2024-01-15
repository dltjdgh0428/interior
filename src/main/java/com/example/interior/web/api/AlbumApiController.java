package com.example.interior.web.api;

import com.example.interior.model.album.Album;
import com.example.interior.service.AlbumService;
import com.example.interior.web.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AlbumApiController {

    private final AlbumService albumService; // AlbumService 인스턴스를 주입받아야 합니다.
    // 특정 앨범의 상세 정보와 이미지 리스트를 반환하는 메소드
    @GetMapping("/api/album/{id}")
    public ResponseEntity<?> getAlbumDetails(@PathVariable int id) {
        Album album = albumService.앨범찾기(id);
        return new ResponseEntity<>(new CMRespDto<>(1, "앨범호출성공", album), HttpStatus.OK);
    }
    @DeleteMapping("/api/album/{id}")
    public ResponseEntity<?> deleteAlbumById(@PathVariable int id){
        albumService.앨범삭제(id);
        return new ResponseEntity<>(new CMRespDto<>(1, "앨범삭제성공", null), HttpStatus.OK);
    }
}
