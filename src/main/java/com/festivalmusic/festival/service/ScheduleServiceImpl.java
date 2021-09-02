package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Schedule;
import com.festivalmusic.festival.model.Singer;
import com.festivalmusic.festival.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> getAllSchedules(List<Singer> singers) {
        return scheduleRepository.getAllSchedules(singers);
    }
}
