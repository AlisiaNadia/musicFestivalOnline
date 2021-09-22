package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Schedule;
import com.festivalmusic.festival.model.Singer;

import java.util.List;

public interface ScheduleRepository {

    Schedule save(Schedule schedule);

    List<Schedule> getAllSchedules(List<Singer> singers);
}
