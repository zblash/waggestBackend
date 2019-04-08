package com.waggest.backend.repositories;

import com.waggest.backend.models.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video,Long> {

    Page<Video> findAllByCategory_Id(Long categoryId, Pageable pageable);

    Optional<Video> findByAddedBy_Id(Long userId);



}
