package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class FestivalRepositoryImpl implements FestivalRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public Festival save(Festival festival) {

        entityManager.persist(festival);
        return festival;
    }
}
