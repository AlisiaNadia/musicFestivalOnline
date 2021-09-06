package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Band;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BandRepositoryImpl implements BandRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Band> getAll() {

        List<Band> bands =
                entityManager.createQuery("select b from Band b").getResultList();

        return bands;
    }

    @Override
    @Transactional
    public Band save(Band band) {
        entityManager.persist(band);
        return band;
    }
}
