package com.waggest.backend.services.abstracts;

import com.waggest.backend.models.Reputation;
import org.springframework.data.domain.Page;

public interface IReputationService {

    Page<Reputation> findAll(int page);

    Reputation findById(Long id);

    Reputation create(Reputation reputation);

    Reputation update(Reputation reputation, Reputation updatedReputation);

    void delete(Reputation reputation);

    Page<Reputation> findAllByVideo(Long video_id, int page);

    Page<Reputation> findAllByUser(Long user_id, int page);
}
