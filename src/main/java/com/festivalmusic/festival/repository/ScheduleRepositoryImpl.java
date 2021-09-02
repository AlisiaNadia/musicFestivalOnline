package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Schedule;
import com.festivalmusic.festival.model.Singer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Schedule save(Schedule schedule) {
        entityManager.persist(schedule);
        return schedule;
    }

    @Override
    public List<Schedule> getAllSchedules(List<Singer> singers) {
        List<Long> schedulesId = new ArrayList<>();

        for (Singer singer: singers) {
            schedulesId.add(singer.getScheduleId().getScheduleId());
        }

        List<Schedule> schedules = entityManager.createQuery
                ("select s from Schedule s where s.scheduleId IN '" + schedulesId + "'").getResultList();
        return schedules;
    }
}
