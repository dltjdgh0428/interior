package com.example.interior.model.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query(value = "select * from image", nativeQuery = true)
    List<Image> mExplore();
}
