package com.festivalmusic.festival.controller;

import com.festivalmusic.festival.model.Festival;
import com.festivalmusic.festival.service.FestivalService;
import com.festivalmusic.festival.validation.FestivalValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FestivalController {

    @Autowired
    FestivalService festivalService;

    @GetMapping("add-festival")
    public String getAddFestival(@ModelAttribute("festival") Festival festival) {
        return "add-festival";
    }

    @PostMapping("add-festival")
    public String addFestival(@ModelAttribute("festival") Festival festival, BindingResult result) {

        new FestivalValidation().validate(festival, result);

        if (result.hasErrors()) {
            return "add-festival";
        }

        Festival festival1 = festivalService.save(festival);

        return "redirect:add-festival";
    }

    @InitBinder
    public final void initBinderUsuariosFormValidator(WebDataBinder binder) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
