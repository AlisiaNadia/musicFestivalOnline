package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Schedule;
import com.festivalmusic.festival.model.Stage;
import com.festivalmusic.festival.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StageServiceImpl implements StageService{

    @Autowired
    StageRepository stageRepository;

    @Override
    public List<Stage> getAll() {
        return stageRepository.getAll();
    }

    @Override
    public List<Stage> getAllStages(List<Schedule> schedules) {
        return  stageRepository.getAllStages(schedules);
    }
}
