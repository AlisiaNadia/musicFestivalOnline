package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Singer;
import com.festivalmusic.festival.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerRepository singerRepository;

    @Override
    @Transactional
    public List<Singer> getAll() {

        List<Singer> singers = singerRepository.getAll();
        return singers;
    }

    @Override
    @Transactional
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }
}
