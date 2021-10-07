package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.FestivalEdition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class FestivalEditionRepositoryImpl implements FestivalEditionRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public FestivalEdition save(FestivalEdition festivalEdition) {
        entityManager.persist(festivalEdition);
        return festivalEdition;
    }

    @Override
    public List<FestivalEdition> getAllFutureFestivalEditions() {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(date);

        List<FestivalEdition> festivalEditions =
                entityManager.createQuery("select fe from FestivalEdition fe where fe.festivalId IN (select f from Festival f where f.startDate > '" + today + "') ").getResultList();
        return festivalEditions;
    }
}
