package com.festivalmusic.festival;

import com.festivalmusic.festival.model.Schedule;
import com.festivalmusic.festival.model.Stage;
import com.festivalmusic.festival.model.User;
import com.festivalmusic.festival.service.SingerService;
import com.festivalmusic.festival.service.StageService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@SpringBootTest
public class StageTest {


    @MockBean
    private StageService stageService;

    private List<Stage> stageList;

    @BeforeEach
    void setStageList() {
        this.stageList = new ArrayList<>();
        this.stageList.add(new Stage("rock", 50));
        this.stageList.add(new Stage("pop", 70));
        this.stageList.add(new Stage("country", 50));
    }


    @Test
    public void getAllStagesTest() {

        Mockito.when(stageService.getAll()).thenReturn(stageList);

        List<Stage> stages = stageService.getAll();

        Assert.assertEquals(stages, stageList);
    }
}
