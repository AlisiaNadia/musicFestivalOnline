package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Band;
import com.festivalmusic.festival.model.BandMembers;
import com.festivalmusic.festival.model.Singer;

import java.util.List;

public interface BandMembersRepository {

    BandMembers save(BandMembers bandMember);
}
