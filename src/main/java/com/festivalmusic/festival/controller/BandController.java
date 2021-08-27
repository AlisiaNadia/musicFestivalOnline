package com.festivalmusic.festival.controller;

import com.festivalmusic.festival.model.*;
import com.festivalmusic.festival.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BandController {

    @Autowired
    private SingerService singerService;

    @Autowired
    private UserService userService;

    @Autowired
    private StageService stageService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private BandService bandService;

    @Autowired
    private BandMembersService bandMembersService;

    @GetMapping("band-registration")
    public String getBandRegistration(@ModelAttribute("bandRegistration") BandRegistration bandRegistration) {
        return "band-registration";
    }

    @PostMapping("band-registration")
    public String addBandRegistration(@Valid @ModelAttribute("bandRegistration") BandRegistration bandRegistration ,
                                         BindingResult result){


        return "redirect:band-registration";
    }


    @ModelAttribute("stageList")
    public List<Stage> getStageList() {
        List<Stage> stages = stageService.getAll();
        return stages;
    }



}
