package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Festival;

import java.util.List;

public interface FestivalRepository {
    Festival save(Festival festival);

    List<Festival> getAll();
}
