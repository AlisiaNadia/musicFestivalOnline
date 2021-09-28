package com.festivalmusic.festival.controller;

import com.festivalmusic.festival.model.*;
import com.festivalmusic.festival.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    TicketService ticketService;

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

    @GetMapping("your-tickets")
    public String getYourTicketsList( @ModelAttribute("ticketInformation") TicketInfo ticketInfo, Model model, Authentication auth) {
        User user  = userService.getUserByUsername(auth.getName());
        List<Ticket> tickets = ticketService.getAllForUser(user);
        model.addAttribute("tickets",tickets );
        return "your-tickets";
    }


    @ModelAttribute("ticketInfoList")
    public List<TicketInfo> getTicketsList() {
        List<TicketInfo> ticketsInfo = ticketInfoService.getAll();
        return ticketsInfo;
    }

}
