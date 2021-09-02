package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Band;
import com.festivalmusic.festival.model.BandMembers;
import com.festivalmusic.festival.model.Singer;

import java.util.List;

public interface BandMembersService {
    List<BandMembers> saveAll(Band savedBand, List<Singer> singers);
}
