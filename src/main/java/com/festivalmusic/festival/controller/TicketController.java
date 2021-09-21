package com.festivalmusic.festival.controller;

import com.festivalmusic.festival.model.*;
import com.festivalmusic.festival.service.AudienceUserService;
import com.festivalmusic.festival.service.StageService;
import com.festivalmusic.festival.service.TicketInfoService;
import com.festivalmusic.festival.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TicketController {

    @Autowired
    StageService stageService;

    @Autowired
    TicketInfoService ticketInfoService;

    @Autowired
    AudienceUserService audienceUserService;

    @Autowired
    UserService userService;

    @GetMapping("buy-ticket")
    public String getBuyTicket( @ModelAttribute("ticketInformation") TicketInfo ticketInfo) {
        return "buy-ticket";
    }

    @PostMapping("buy-ticket")
    public String addBuyTicket(@ModelAttribute("ticketInformation") TicketInfo ticketInfo,
                               BindingResult result, Authentication auth) {
        if (result.hasErrors()) {
            return "buy-ticket";
        }
        User user  = userService.getUserByUsername(auth.getName());

        AudienceUser audienceUser = audienceUserService.save(ticketInfo.getTicketInfoId() ,user);

        return "redirect:buy-ticket";
    }

    @ModelAttribute("ticketInfoList")
    public List<TicketInfo> getTicketsList() {

        List<TicketInfo> ticketsInfo = ticketInfoService.getAll();
        return ticketsInfo;
    }

}
