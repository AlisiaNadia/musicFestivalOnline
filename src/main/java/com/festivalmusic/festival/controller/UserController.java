package com.festivalmusic.festival.controller;

import com.festivalmusic.festival.model.User;
import com.festivalmusic.festival.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute("registration") User user) {
        return "registration";
    }


    @PostMapping("registration")
    public String addRegistration(@Valid  @ModelAttribute("registration") User user, BindingResult result, Model model)  {

        if(result.hasErrors()) {
             return "registration";
        }

        User user1 = userService.save(user);
        if(user1 == null) {
            model.addAttribute("errors", "The username is already in use!");
            return "registration";
        }
        return "redirect:login";
    }

    @GetMapping("login")
    public String getLogin(@ModelAttribute("login") User user) {
        return "login";
    }

}
