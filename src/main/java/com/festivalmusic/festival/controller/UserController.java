package com.festivalmusic.festival.controller;

import com.festivalmusic.festival.model.User;
import com.festivalmusic.festival.service.UserService;
import com.festivalmusic.festival.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

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

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

       Set<ConstraintViolation<User>> errors = validator.validate(user);

       if (!errors.isEmpty()) {
           for (ConstraintViolation<User> userError:errors) {
               String emailError = String.valueOf(userError.getPropertyPath()) + "Error";
               model.addAttribute(emailError, userError.getMessage());
           }
           return "registration";
        }

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
