package com.example.interior.service;

import com.example.interior.model.album.Album;
import com.example.interior.model.album.AlbumRepository;
import com.example.interior.model.image.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AlbumService {

    private final ImageRepository imageRepository;
    private final AlbumRepository albumRepository;

    @Transactional(readOnly = true)
    public List<Album> 전체앨범(){
        return albumRepository.mExplore();
    }
    
    @Transactional(readOnly = true)
    public Album 앨범찾기(int id){
        return albumRepository.mfind(id);
    }

    @Transactional
    public void 앨범업로드(Album album) {
        albumRepository.save(album);
    }

    @Transactional
    public void 앨범삭제(int albumId) {
        // 앨범과 연관된 이미지를 먼저 삭제
        imageRepository.deleteByAlbumId(albumId);
        // 그 다음 앨범 삭제
        albumRepository.deleteById(albumId);
    }

    @Transactional
    public void 캡션수정(int albumId, String newCaption) {

        Album album = albumRepository.findById(albumId).orElseThrow();

        if (album!=null) {
            album.setCaption(newCaption);
            albumRepository.save(album);
        } else {

            throw new EntityNotFoundException("Album with id " + albumId + " not found");
        }
    }


}
