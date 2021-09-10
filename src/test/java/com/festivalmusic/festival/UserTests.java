package com.festivalmusic.festival;

import com.festivalmusic.festival.model.User;
import com.festivalmusic.festival.repository.UserRepository;
import com.festivalmusic.festival.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserTests {


    @MockBean
    private UserService userService;

    private List<User> userList;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUsersList() {
        this.userList = new ArrayList<>();
        this.userList.add(new User("user1LastName", "user1FirstName", "user1email@email.com", "02443458754", "user1 address","user1",passwordEncoder.encode("user1"), "ROLES_USER"));
        this.userList.add(new User("user2LastName", "user2FirstName", "user2email@email.com", "08976435433", "user2 address","user2",passwordEncoder.encode("user2"), "ROLES_USER"));
        this.userList.add(new User("user3LastName", "user3FirstName", "user3email@email.com", "02443228754", "user3 address","user3",passwordEncoder.encode("user3"), "ROLES_USER"));
        this.userList.add(new User("user4LastName", "user4FirstName", "user4email@email.com", "02432458954", "user4 address","user4",passwordEncoder.encode("user4"), "ROLES_USER"));

    }

    @Test
    public void saveUserTest() {
        User user = userList.get(1);

        Mockito.when(userService.save(user)).thenReturn(user);

        User userSaved = userService.save(user);

        Assert.assertEquals(user, userSaved);
    }

    @Test
    public void saveAllUsersTest() {

        Mockito.when(userService.saveAll(userList)).thenReturn(userList);

        List<User> users = userService.saveAll(userList);

        Assert.assertEquals(userList, users);
    }

    @Test
    public void findByUsernameTest() {

        String username = "user1";

        Mockito.when(userService.getUserByUsername(username)).thenReturn(userList.get(0));

        User user = userService.getUserByUsername(username);

        Assert.assertEquals(username, user.getUsername());

    }

}
