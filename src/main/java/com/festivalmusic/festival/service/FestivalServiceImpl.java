package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Festival;
import com.festivalmusic.festival.repository.FestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FestivalServiceImpl implements FestivalService {

    @Autowired
    FestivalRepository festivalRepository;

    @Override
    public Festival save(Festival festival) {
        return festivalRepository.save(festival);
    }

    @Override
    public List<Festival> getAll() {
        return festivalRepository.getAll();
    }
}
