package com.waggest.backend.services.concretes;

import com.waggest.backend.models.Comment;
import com.waggest.backend.repositories.CommentRepository;
import com.waggest.backend.services.abstracts.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Page<Comment> findAll(int page) {
        return commentRepository.findAll(PageRequest.of(page,10));
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment, Comment updatedComment) {
        comment.setComment(updatedComment.getComment());
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Comment category) {
        commentRepository.delete(category);
    }

    @Override
    public Page<Comment> findAllByVideo(Long videoId, int page) {
        return commentRepository.findAllByVideo_Id(videoId, PageRequest.of(page,10));
    }
}
