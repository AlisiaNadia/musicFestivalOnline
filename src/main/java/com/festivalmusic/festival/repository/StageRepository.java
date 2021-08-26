package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Schedule;
import com.festivalmusic.festival.model.Stage;

import java.util.List;

public interface StageRepository {
    List<Stage> getAll();

    List<Stage> getAllStages(List<Schedule> schedules);
}
