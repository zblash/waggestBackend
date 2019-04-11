package com.waggest.backend.services.abstracts;

import com.waggest.backend.models.Comment;
import org.springframework.data.domain.Page;

public interface ICommentService {

    Page<Comment> findAll(int page);

    Comment findById(Long id);

    Comment create(Comment comment);

    Comment update(Comment comment, Comment updatedComment);

    void delete(Comment category);

    Page<Comment> findAllByVideo(Long videoId, int page);
}
