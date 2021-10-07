package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.AddStage;
import com.festivalmusic.festival.model.FestivalEdition;
import com.festivalmusic.festival.repository.FestivalEditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FestivalEditionServiceImpl implements FestivalEditionService {

    @Autowired
    FestivalEditionRepository festivalEditionRepository;

    @Override
    public FestivalEdition save(FestivalEdition festivalEdition) {
        return festivalEditionRepository.save(festivalEdition);
    }

    @Override
    public List<AddStage> getAllFutureFestivalEditions() {

        List<FestivalEdition> festivals = festivalEditionRepository.getAllFutureFestivalEditions();

        List<AddStage> stageList = new ArrayList<>(festivals.size());

        for (FestivalEdition festival:festivals) {
            AddStage stage = new AddStage();
            stage.setFestival(festival.getFestivalId());
            stage.setStage(festival.getStageId());

        }

        return null;
    }

}
