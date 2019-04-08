package com.waggest.backend.repositories;

import com.waggest.backend.models.Reputation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReputationRepository extends JpaRepository<Reputation,Long> {

    Page<Reputation> findAllByVideo_Id(Long video_id, Pageable pageable);

    Page<Reputation> findAllByUser_Id(Long user_id, Pageable pageable);

}
