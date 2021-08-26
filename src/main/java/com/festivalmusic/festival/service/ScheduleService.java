package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Schedule;
import com.festivalmusic.festival.model.Singer;

import java.util.List;

public interface ScheduleService {
    Schedule save(Schedule schedule);

    List<Schedule> getAllSchedules(List<Singer> singers);
}
