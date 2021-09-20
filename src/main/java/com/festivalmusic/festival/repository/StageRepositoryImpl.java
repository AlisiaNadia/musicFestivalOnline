package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Schedule;
import com.festivalmusic.festival.model.Stage;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StageRepositoryImpl implements StageRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Stage> getAll() {
        List<Stage> registrationList =
                entityManager.createQuery("select r from Stage r").getResultList();
        return registrationList;
    }

}
