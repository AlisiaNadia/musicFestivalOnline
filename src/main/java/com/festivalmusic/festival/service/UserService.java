package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Singer;
import com.festivalmusic.festival.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User save(User user);

    //Boolean getUser(User user);

    List<User> saveAll(List<User> users);

    User getUserByUsername(String name);
}
