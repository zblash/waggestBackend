package com.waggest.backend.services.abstracts;

import com.waggest.backend.models.Video;
import org.springframework.data.domain.Page;

public interface IVideoService {

    Page<Video> findAll(int page);

    Video findById(Long id);

    Video create(Video video);

    Video update(Video video, Video updatedVideo);

    void delete(Video video);

    Page<Video> findAllByCategory(Long categoryId, int page);

    Video findByAddedBy(Long userId);
}
