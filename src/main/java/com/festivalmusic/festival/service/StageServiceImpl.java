package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Stage;
import com.festivalmusic.festival.repository.StageRepository;
import com.festivalmusic.festival.repository.TicketInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StageServiceImpl implements StageService{

    @Autowired
    StageRepository stageRepository;

    @Autowired
    TicketInfoRepository ticketInfoRepository;


    @Override
    public List<Stage> getAll() {
        return stageRepository.getAll();
    }

    @Override
    public Long getTheMostLikelyStageToBeSoldOut() {

        Map<Long, Integer> stages = ticketInfoRepository.getTheMostLikelyStageToBeSoldOut();

        Long stageMostLikelyToBeSoldOut = stages
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .get()
                .getKey();

        return stageMostLikelyToBeSoldOut;
    }

    @Override
    public String getTheMostPopularGenre() {

        Map<String,  Integer> genres = ticketInfoRepository.getTheMostPopularGenre();

        String mostPopularGenre = genres
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .get()
                .getKey();

        return mostPopularGenre;
    }

    @Override
    public Stage save(Stage stage) {
        return stageRepository.save(stage);
    }
}
