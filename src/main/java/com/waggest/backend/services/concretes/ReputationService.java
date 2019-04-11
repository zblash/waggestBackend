package com.waggest.backend.services.concretes;

import com.waggest.backend.models.Reputation;
import com.waggest.backend.repositories.ReputationRepository;
import com.waggest.backend.services.abstracts.IReputationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ReputationService implements IReputationService {

    @Autowired
    private ReputationRepository reputationRepository;

    @Override
    public Page<Reputation> findAll(int page) {
        return reputationRepository.findAll(PageRequest.of(page,10));
    }

    @Override
    public Reputation findById(Long id) {
        return reputationRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Reputation create(Reputation reputation) {
        return reputationRepository.save(reputation);
    }

    @Override
    public Reputation update(Reputation reputation, Reputation updatedReputation) {
        reputation.setReputation(updatedReputation.getReputation());
        return reputationRepository.save(reputation);
    }

    @Override
    public void delete(Reputation reputation) {
        reputationRepository.delete(reputation);
    }

    @Override
    public Page<Reputation> findAllByVideo(Long video_id, int page) {
        return reputationRepository.findAllByVideo_Id(video_id, PageRequest.of(page,10));
    }

    @Override
    public Page<Reputation> findAllByUser(Long user_id, int page) {
        return reputationRepository.findAllByUser_Id(user_id, PageRequest.of(page,10));
    }
}
