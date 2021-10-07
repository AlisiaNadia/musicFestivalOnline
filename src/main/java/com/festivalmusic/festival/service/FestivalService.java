package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Festival;

import java.util.List;

public interface FestivalService {
    Festival save(Festival festival);

    List<Festival> getAll();
}
