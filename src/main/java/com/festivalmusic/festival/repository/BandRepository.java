package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Band;

import java.util.List;

public interface BandRepository {

    List<Band> getAll();

    Band save(Band band);
}
