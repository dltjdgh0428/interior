package com.example.interior.model.cover;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoverRepository extends JpaRepository<Cover, Integer> {
    @Query(value = "select * from cover", nativeQuery = true)
    List<Cover> mExplore();
}
