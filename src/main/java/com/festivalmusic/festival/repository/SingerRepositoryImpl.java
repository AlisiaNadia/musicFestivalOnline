package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Singer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.SQLOutput;
import java.util.List;

@Repository
public class SingerRepositoryImpl implements SingerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Singer> getAll() {

        List<Singer> singers =
                entityManager.createQuery("select s from Singer s").getResultList();
        return singers;
    }

    @Override
    @Transactional
    public Singer save(Singer singer) {
        entityManager.persist(singer);
        return singer;
    }
}
