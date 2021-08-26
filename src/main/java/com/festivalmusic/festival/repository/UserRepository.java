package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Singer;
import com.festivalmusic.festival.model.User;

import java.util.List;

public interface UserRepository {

    User findByUsername(String username);

    User save(User user);

    Boolean getUser(User user);

    List<User> getAllUsers(List<Singer> singers);

}
