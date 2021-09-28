package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.User;

public interface UserRepository {

    User findByUsername(String username);

    User save(User user);

}
