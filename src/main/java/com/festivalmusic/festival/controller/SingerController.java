package com.festivalmusic.festival.controller;

import com.festivalmusic.festival.model.*;
import com.festivalmusic.festival.service.ScheduleService;
import com.festivalmusic.festival.service.SingerService;
import com.festivalmusic.festival.service.UserService;
import com.festivalmusic.festival.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SingerController {


    @Autowired
    private SingerService singerService;

    @Autowired
    private UserService userService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private StageService stageService;

    @GetMapping("singer-registration")
    public String getSingersRegistration(@ModelAttribute("singerRegistration")SingerRegistration  singerRegistration) {
        return "singer-registration";
    }

    @PostMapping("singer-registration")
    public String addSingersRegistration(@Valid @ModelAttribute("singerRegistration") SingerRegistration singerRegistration ,
                                         BindingResult result) {

        Stage stage = singerRegistration.getStage();
        List<Stage> stages = getStageList();
        for (Stage stg: stages) {
            if(stg.getStageId().equals(stage.getStageId())) {
                stage = stg;
            }

        }
        User userForSinger = userService.save(singerRegistration.getUser());

        Schedule singerSchedule = singerRegistration.getSchedule();
        singerSchedule.setStageId(stage);
        Schedule saveSchedule = scheduleService.save(singerSchedule);

        Singer singer = new Singer();
        singer.setUserId(userForSinger);
        singer.setScheduleId(saveSchedule);
        Singer singer1 = singerService.save(singer);

        return "redirect:singer-registration";
    }

    @ModelAttribute("stageList")
    public List<Stage> getStageList() {
        List<Stage> stages = stageService.getAll();
        return stages;
    }

    @InitBinder
    public final void initBinderUsuariosFormValidator(WebDataBinder binder) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("singersList")
    public String getSingersList(Model model) {
        List<Singer> singers = singerService.getAll();
        List<User> users = userService.getAllUsers(singers);
        List<Schedule> schedules = scheduleService.getAllSchedules(singers);
        List<Stage> stages = stageService.getAllStages(schedules);

        List<SingerRegistration> singerRegistrations = new ArrayList<>();
        for (int i = 0; i<singers.size(); i++) {
            singerRegistrations.add(new SingerRegistration(users.get(i), schedules.get(i), stages.get(i)));
        }
        model.addAttribute("singersList", singerRegistrations);

        return "singersList";
    }
}
