package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Singer;
import com.festivalmusic.festival.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        List<User> users =
                entityManager.createQuery("select u from User u where u.username= '"+ username +"'").getResultList();
        if(users.size() == 1) {
            return users.get(0);
        }
        return null;
    }

    @Override
    @Transactional
    public User save(User user) {

        user.setRoles("ROLES_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<User> users =
                entityManager.createQuery("select u from User u where u.username= '"+ user.getUsername() +"'").getResultList();

        if(users.size() == 1) {
           return null;
       }
        entityManager.persist(user);
        return user;

    }


    @Override
    public Boolean getUser(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        User userExists =
                (User) entityManager.createQuery
                        ("select u from User u where u.email = '" + email + "' and u.password = '" + password + "' ");

        if (userExists != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers(List<Singer> singers) {

        List<Long> usersId = new ArrayList<>();

        for (Singer singer: singers) {
            usersId.add(singer.getUserId().getUserId());
        }
        List<User> users = entityManager.createQuery
                ("select u from User u where u.userId IN :usersId ").getResultList();
        return users;
    }

}
