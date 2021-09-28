package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.TicketInfo;

import java.util.List;
import java.util.Map;

public interface TicketInfoRepository {
    List<TicketInfo> getAll();

    Map<String, Integer> getTheMostLikelyTicketToBeSoldOut();

    Map<Long, Integer> getTheMostLikelyStageToBeSoldOut();

    Map<String, Integer> getTheMostPopularGenre();

    TicketInfo save(TicketInfo ticket);
}
