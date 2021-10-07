package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<Festival> getAll() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(date);

        List<Festival> festivalList =
                entityManager.createQuery("select f from Festival f where f.startDate > '" + today + "'").getResultList();
        return festivalList;
    }
}
