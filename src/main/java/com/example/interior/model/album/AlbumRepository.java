package com.example.interior.model.album;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Query(value = "select * from album", nativeQuery = true)
    List<Album> mExplore();

    @Query(value = "select * from album where id=:albumId", nativeQuery = true)
    Album mfind(@Param("albumId") int albumId);
}
