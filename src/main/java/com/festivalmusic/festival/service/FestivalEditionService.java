package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.AddStage;
import com.festivalmusic.festival.model.FestivalEdition;

import java.util.List;

public interface FestivalEditionService {

    FestivalEdition save(FestivalEdition festivalEdition);

    List<AddStage> getAllFutureFestivalEditions();
}
