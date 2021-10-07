package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.FestivalEdition;

import java.util.List;

public interface FestivalEditionRepository {

    FestivalEdition save(FestivalEdition festivalEdition);

    List<FestivalEdition> getAllFutureFestivalEditions();
}
