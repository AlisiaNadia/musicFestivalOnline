package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Singer;

import java.util.List;

public interface SingerRepository {
    List<Singer> getAll();

    Singer save(Singer singer);
}
