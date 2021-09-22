package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Schedule;
import com.festivalmusic.festival.model.Singer;
import com.festivalmusic.festival.model.User;

import java.util.List;

public interface SingerService {

    List<Singer> getAll();

    Singer save(Singer singer);

    List<Singer> saveAll(List<User> users, Schedule savedSchedule);
}
