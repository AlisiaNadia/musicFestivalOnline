package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Singer;
import com.festivalmusic.festival.model.User;
import com.festivalmusic.festival.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user){
        return userRepository.save(user);
    }


//    @Override
//    public Boolean getUser(User user) {
//        return userRepository.getUser(user);
//    }

    @Override
    public List<User> saveAll(List<User> users) {

        List<User> userList = new ArrayList<>();
        for (User user: users) {
            userList.add(userRepository.save(user));
        }
        return userList;
    }

    @Override
    public User getUserByUsername(String username) {
        return  userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("wrong username");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRoles()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
