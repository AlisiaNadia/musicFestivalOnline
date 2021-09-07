package com.festivalmusic.festival.controller;

import com.festivalmusic.festival.model.*;
import com.festivalmusic.festival.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @RequestMapping(value = "band-registration", method = RequestMethod.POST, params = "addMember")
    public String addBandMember(Model model, @ModelAttribute("bandRegistration") BandRegistration bandRegistration ,
                                      BindingResult result) {

        List<User> users = new ArrayList<>();
        if( bandRegistration.getUsers() == null ) {
            users.add(new User());
        } else {
           users = bandRegistration.getUsers();
            users.add(new User());
        }
        bandRegistration.setUsers(users);

       model.addAttribute("bandRegistration",bandRegistration);
       return "band-registration";
    }

    @RequestMapping(value = "band-registration", method = RequestMethod.POST, params = "register")
    public String addBandRegistration(@ModelAttribute("bandRegistration") BandRegistration bandRegistration ,
                                      BindingResult result){

        if(result.hasErrors()) {
            return "band-registration";
        }

        List<User> users = userService.saveAll(bandRegistration.getUsers());

        Schedule savedSchedule = scheduleService.save(bandRegistration.getSchedule());

        Band band = bandService.save(new Band(bandRegistration.getName()));

        List<Singer> singers = singerService.saveAll(users,savedSchedule);

        List<BandMembers> bandMembers =  bandMembersService.saveAll(band, singers);

        return "redirect:band-registration";
    }

    @ModelAttribute("bandStageList")
    public List<Stage> getBandStageList() {
        List<Stage> stages = stageService.getAll();
        return stages;
    }

    @InitBinder
    public final void initBinderUsuariosFormValidator(WebDataBinder binder) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


    @GetMapping("bandsList")
    public String getBandsList(@ModelAttribute("band") Band band, Model model) {
        List<Band> bands = bandService.getAll();
        model.addAttribute("bandsList",bands );
        return "bandsList";
    }


}
