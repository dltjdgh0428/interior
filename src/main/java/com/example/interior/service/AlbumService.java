package com.example.interior.service;

import com.example.interior.model.album.Album;
import com.example.interior.model.album.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AlbumService {
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
    public void 앨범삭제(int id) {
        albumRepository.deleteById(id);
    }
}
