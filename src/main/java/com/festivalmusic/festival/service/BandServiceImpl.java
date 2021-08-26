package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Band;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BandServiceImpl implements BandService {


    @Override
    @Transactional
    public List<Band> getAll() {
        return null;
    }
}
