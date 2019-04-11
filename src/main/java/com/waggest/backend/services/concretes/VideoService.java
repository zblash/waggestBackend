package com.waggest.backend.services.concretes;

import com.waggest.backend.models.Video;
import com.waggest.backend.repositories.VideoRepository;
import com.waggest.backend.services.abstracts.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VideoService implements IVideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Page<Video> findAll(int page) {
        return videoRepository.findAll(PageRequest.of(page,10));
    }

    @Override
    public Video findById(Long id) {
        return videoRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Video create(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public Video update(Video video, Video updatedVideo) {
        video.setAddedBy(updatedVideo.getAddedBy());
        video.setCategory(updatedVideo.getCategory());
        video.setUrl(updatedVideo.getUrl());
        return videoRepository.save(video);
    }

    @Override
    public void delete(Video video) {
        videoRepository.delete(video);
    }

    @Override
    public Page<Video> findAllByCategory(Long categoryId, int page) {
        return videoRepository.findAllByCategory_Id(categoryId,PageRequest.of(page,10));
    }

    @Override
    public Video findByAddedBy(Long userId) {
        return videoRepository.findByAddedBy_Id(userId).orElseThrow(RuntimeException::new);
    }
}
