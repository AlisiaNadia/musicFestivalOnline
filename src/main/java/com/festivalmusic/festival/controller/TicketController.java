package com.festivalmusic.festival.controller;

import com.festivalmusic.festival.model.BandRegistration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TicketController {

    @GetMapping("ticket")
    public String getBandRegistration(@ModelAttribute("ticket") BandRegistration bandRegistration) {
        return "ticket";
    }
}
