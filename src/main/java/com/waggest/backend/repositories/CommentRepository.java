package com.waggest.backend.repositories;

import com.waggest.backend.models.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    Page<Comment> findAllByVideo_Id(Long video_id, Pageable pageable);

}
