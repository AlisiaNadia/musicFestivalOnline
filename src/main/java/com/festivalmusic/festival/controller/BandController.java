package com.festivalmusic.festival.controller;

import com.festivalmusic.festival.model.*;
import com.festivalmusic.festival.service.*;
import com.festivalmusic.festival.validation.BandValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    private BandValidation bandValidation;

    @GetMapping("band-registration")
    public String getBandRegistration(@ModelAttribute("bandRegistration") BandRegistration bandRegistration, Model model) {

        List<User> users = new ArrayList<>();

        users.add(new User());
        users.add(new User());

        bandRegistration.setUsers(users);
        model.addAttribute("bandRegistration",bandRegistration);

      return "band-registration";
    }

    @RequestMapping(value = "band-registration", method = RequestMethod.POST, params = "addMember")
    public String addBandMember(Model model, @ModelAttribute("bandRegistration") BandRegistration bandRegistration ,
                                      BindingResult result) {

        List<User> users = new ArrayList<>();

        if ( bandRegistration.getUsers() == null ) {
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
                                      BindingResult result, Model model) {

        bandValidation.validate(bandRegistration, result);

        List<String> userErrors = new ArrayList<String>(bandRegistration.getUsers().size());
        List<String> errorsBandMembers = new ArrayList<>(bandRegistration.getUsers().size());

        System.out.println(bandRegistration.getUsers().size() + "sssssssssssss55555555555555555555555555555555555555sssssssssssss" + errorsBandMembers.size());

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        if (bandRegistration.getUsers().size() > 0) {

            for (int i = 0; i < bandRegistration.getUsers().size(); i++) {

                User usernameCheck = userService.getUserByUsername(bandRegistration.getUsers().get(i).getUsername());

                if (usernameCheck != null) {
                    userErrors.add("This username is already in use");
                } else {
                    userErrors.add(null);
                }

                Set<ConstraintViolation<User>> errors = validator.validate(bandRegistration.getUsers().get(i));

                if (!errors.isEmpty()) {
                    for (ConstraintViolation<User> userError : errors) {
                        errorsBandMembers.add(i,userError.getMessage());
                    }
                } else {
                    errorsBandMembers.add(null);
                }

            }

        }

        if (!errorsBandMembers.isEmpty()) {
            model.addAttribute("errorsBandMembers", errorsBandMembers);
            return "band-registration";
        }

        if (!userErrors.isEmpty()) {
                model.addAttribute("usernameErrors", userErrors);
                return "band-registration";
        }

        if (result.hasErrors()) {
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
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("bandsList")
    public String getBandsList(@ModelAttribute("band") Band band, Model model) {
        List<Band> bands = bandService.getAll();
        model.addAttribute("bandsList",bands );
        return "bandsList";
    }

}
