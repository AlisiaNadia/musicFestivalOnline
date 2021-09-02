package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Band;
import com.festivalmusic.festival.model.BandMembers;
import com.festivalmusic.festival.model.Singer;
import com.festivalmusic.festival.repository.BandMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BandMembersServiceImpl implements BandMembersService{

    @Autowired
    BandMembersRepository bandMembersRepository;

    @Override
    public List<BandMembers> saveAll(Band savedBand, List<Singer> singers) {

        List<BandMembers>bandMembers = new ArrayList<>();

        for (Singer singer:singers) {

            BandMembers bandMember = new BandMembers(singer, savedBand);
            BandMembers member = bandMembersRepository.save(bandMember);

            bandMembers.add(member);
        }
        return bandMembers;
    }
}
