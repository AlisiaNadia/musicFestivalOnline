package com.festivalmusic.festival.controller;

import com.festivalmusic.festival.model.User;
import com.festivalmusic.festival.service.UserService;
import com.festivalmusic.festival.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute("registration") User user) {
        return "registration";
    }


    @PostMapping("registration")
    public String addRegistration(@ModelAttribute("registration") User user, BindingResult result, Model model)  {

        new UserValidation().validate(user, result);

        User usernameCheck = userService.getUserByUsername(user.getUsername());

        if (usernameCheck != null) {
            model.addAttribute("usernameExists", "The username is already in use!");
            return "registration";
        }

        if (result.hasErrors()) {
            return "registration";
        }

        User user1 = userService.save(user);
        return "redirect:login";
    }

    @GetMapping("login")
    public String getLogin(@ModelAttribute("login") User user) {
        return "login";
    }

}
