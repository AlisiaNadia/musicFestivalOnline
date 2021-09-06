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
                                         BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "singer-registration";
        }

        User singerUser = userService.save(singerRegistration.getUser());

        if(singerUser == null) {
            model.addAttribute("errors", "The username is already in use!");
            return "singer-registration";
        }

        Schedule saveSchedule = scheduleService.save(singerRegistration.getSchedule());

        Singer singer =  singerService.save(new Singer(singerUser, saveSchedule));

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
    public String getSingersListRegistration(@ModelAttribute("singer") Singer singer, Model model) {
        List<Singer> singers = singerService.getAll();
        model.addAttribute("singersList",singers );
        return "singersList";
    }

}
