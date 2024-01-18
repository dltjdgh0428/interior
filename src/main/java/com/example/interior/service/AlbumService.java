package com.example.interior.service;

import com.example.interior.model.album.Album;
import com.example.interior.model.album.AlbumRepository;
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
    @PersistenceContext
    private EntityManager entityManager;
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
        entityManager.createNativeQuery("DELETE FROM Image WHERE album_id = :albumId")
                .setParameter("albumId", albumId)
                .executeUpdate();

        // 이후 앨범 삭제
        entityManager.createNativeQuery("DELETE FROM Album WHERE id = :albumId")
                .setParameter("albumId", albumId)
                .executeUpdate();
    }

    @Transactional
    public void 캡션수정(int albumId, String newCaption) {

        Optional<Album> album = albumRepository.findById(albumId);

        if (album.isPresent()) {
            Album existingAlbum = album.get();
            existingAlbum.setCaption(newCaption);
            albumRepository.save(existingAlbum);
        } else {

            throw new EntityNotFoundException("Album with id " + albumId + " not found");
        }
    }


}
