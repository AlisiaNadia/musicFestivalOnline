package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        User user = (User) entityManager.createQuery("select u from User u where u.username= '"+
                username +"'").getResultList().stream().findFirst().orElse(null);

        return user;
    }

    @Override
    @Transactional
    public User save(User user) {

        user.setRoles("ROLES_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
}
