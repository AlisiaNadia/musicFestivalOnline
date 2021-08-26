package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> getAll();

    Singer save(Singer singer);
}
