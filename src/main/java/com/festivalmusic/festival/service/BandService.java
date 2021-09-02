package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Band;

import java.util.List;

public interface BandService {
    List<Band> getAll();

    Band save(Band band);
}
