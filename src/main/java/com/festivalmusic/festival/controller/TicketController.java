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

import javax.validation.Valid;
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
    public String getBuyTicket(@Valid @ModelAttribute("ticketInformation") TicketInfo ticketInfo) {
        return "buy-ticket";
    }

    @PostMapping("buy-ticket")
    public String addBuyTicket(@Valid @ModelAttribute("ticketInformation") TicketInfo ticketInfo,
                               BindingResult result, Authentication auth) {
        System.out.println("ticket"  + ticketInfo.getTicketInfoId() + auth.getName());

        User user  = userService.getUserByUsername(auth.getName());

        AudienceUser audienceUser = audienceUserService.save(ticketInfo.getTicketInfoId() ,user);

        System.out.println(audienceUser + "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        return "redirect:buy-ticket";
    }

    @ModelAttribute("ticketInfoList")
    public List<TicketInfo> getTicketsList() {

        List<TicketInfo> ticketsInfo = ticketInfoService.getAll();
       // System.out.println(ticketsInfo + "+----------------------------------------------------");
        return ticketsInfo;


    }
}
