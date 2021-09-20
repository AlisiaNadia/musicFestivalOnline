package com.festivalmusic.festival;

import com.festivalmusic.festival.model.Schedule;
import com.festivalmusic.festival.model.Singer;
import com.festivalmusic.festival.model.Stage;
import com.festivalmusic.festival.model.User;
import com.festivalmusic.festival.service.SingerService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class SingerTest {

    @MockBean
    private SingerService singerService;

    private List<User> userList;

    private List<Singer> singerList;

    private List<Schedule> scheduleList;

    private List<Stage> stageList;

    private  Date today = new Date();

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setSingerList() {

        this.userList = new ArrayList<>();
        this.userList.add(new User("user1LastName", "user1FirstName", "user1email@email.com", "02443458754", "user1 address","user1",passwordEncoder.encode("user1"), "ROLES_USER"));
        this.userList.add(new User("user2LastName", "user2FirstName", "user2email@email.com", "08976435433", "user2 address","user2",passwordEncoder.encode("user2"), "ROLES_USER"));
        this.userList.add(new User("user3LastName", "user3FirstName", "user3email@email.com", "02443228754", "user3 address","user3",passwordEncoder.encode("user3"), "ROLES_USER"));
        this.userList.add(new User("user4LastName", "user4FirstName", "user4email@email.com", "02432458954", "user4 address","user4",passwordEncoder.encode("user4"), "ROLES_USER"));

        this.stageList = new ArrayList<>();
        this.stageList.add(new Stage(1L,"rock", 50));
        this.stageList.add(new Stage(2l,"pop", 70));
        this.stageList.add(new Stage(3L,"country", 50));

        this.scheduleList = new ArrayList<>();
        this.scheduleList.add(new Schedule(today, "12:30", stageList.get(1)));
        this.scheduleList.add(new Schedule(today, "14:30", stageList.get(0)));
        this.scheduleList.add(new Schedule(today, "15:30", stageList.get(2)));

        this.singerList = new ArrayList<>();
        this.singerList.add(new Singer(userList.get(1), scheduleList.get(1)));
    }

    @Test
    public void saveSingerTest() {

        Mockito.when(singerService.save(singerList.get(0))).thenReturn(singerList.get(0));

        Singer singer = singerService.save(singerList.get(0));

        Assert.assertEquals(singer, singerList.get(0));

    }

    @Test
    public void getAllSingersTest() {

        Mockito.when(singerService.getAll()).thenReturn(singerList);

        List<Singer> singer = singerService.getAll();

        Assert.assertEquals(singer, singerList);

    }

}
