package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.AudienceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class AudienceUserRepositoryImpl implements AudienceUserRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public AudienceUser save(AudienceUser audienceUser) {
        entityManager.persist(audienceUser);
        return audienceUser;
    }
}
