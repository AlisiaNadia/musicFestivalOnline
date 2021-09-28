package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Stage;

import java.util.List;

public interface StageService {

    List<Stage> getAll();

    Long getTheMostLikelyStageToBeSoldOut();

    String getTheMostPopularGenre();

    Stage save(Stage stage);
}
