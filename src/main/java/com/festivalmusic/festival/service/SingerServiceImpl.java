package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Schedule;
import com.festivalmusic.festival.model.Singer;
import com.festivalmusic.festival.model.User;
import com.festivalmusic.festival.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerRepository singerRepository;

    @Override
    public List<Singer> getAll() {

        List<Singer> singers = singerRepository.getAll();
        return singers;
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    public List<Singer> saveAll(List<User> users, Schedule savedSchedule) {
        List<Singer> singers = new ArrayList<>();

        for (User user:users) {
            Singer singer = new Singer(user, savedSchedule);
            Singer savedSinger = singerRepository.save(singer);
            singers.add(savedSinger);
        }

        return singers;
    }
}
