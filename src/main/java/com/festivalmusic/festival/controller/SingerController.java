package com.festivalmusic.festival.controller;

import com.festivalmusic.festival.model.*;
import com.festivalmusic.festival.service.ScheduleService;
import com.festivalmusic.festival.service.SingerService;
import com.festivalmusic.festival.service.UserService;
import com.festivalmusic.festival.service.StageService;
import com.festivalmusic.festival.validation.SingleValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    public String addSingersRegistration(@ModelAttribute("singerRegistration") SingerRegistration singerRegistration ,

                                         BindingResult result, Model model) {

        new SingleValidation().validate(singerRegistration, result);

        User usernameCheck = userService.getUserByUsername(singerRegistration.getUser().getUsername());

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> errors = validator.validate(singerRegistration.getUser());

        if (!errors.isEmpty()) {
            for (ConstraintViolation<User> userError:errors) {
                String emailError = String.valueOf(userError.getPropertyPath()) + "Error";
                model.addAttribute(emailError, userError.getMessage());
            }
            return "singer-registration";
        }

        if (usernameCheck != null) {

            model.addAttribute("usernameExists", "The username is already in use!");
            return "singer-registration";
        }

        if (result.hasErrors()) {
            return "singer-registration";
        }


        User singerUser = userService.save(singerRegistration.getUser());

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
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("singersList")
    public String getSingersListRegistration(@ModelAttribute("singer") Singer singer, Model model) {
        List<Singer> singers = singerService.getAll();
        model.addAttribute("singersList",singers );
        return "singersList";
    }

}
