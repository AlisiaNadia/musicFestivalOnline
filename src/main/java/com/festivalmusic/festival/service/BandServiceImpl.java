package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Band;
import com.festivalmusic.festival.model.BandRegistration;
import com.festivalmusic.festival.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BandServiceImpl implements BandService {

    @Autowired
    BandRepository bandRepository;

    @Override
    public List<Band> getAll() {
        return null;
    }

    @Override
    public Band save(Band band) {

        return bandRepository.save(band);
    }
}
