package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Schedule;
import com.festivalmusic.festival.model.Stage;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Stage> getAllStages(List<Schedule> schedules) {
        List<Long> stagesId = new ArrayList<>();

        for (Schedule schedule: schedules) {
            stagesId.add(schedule.getStageId().getStageId());
        }

        List<Stage> stages = entityManager.createQuery
                ("select s from Stage s where s.stageId IN '" + stagesId + "'").getResultList();
        return stages;
    }
}
