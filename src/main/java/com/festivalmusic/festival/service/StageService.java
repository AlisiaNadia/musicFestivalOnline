package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Schedule;
import com.festivalmusic.festival.model.Stage;

import java.util.List;

public interface StageService {
    List<Stage> getAll();

    List<Stage> getAllStages(List<Schedule> schedules);
}
