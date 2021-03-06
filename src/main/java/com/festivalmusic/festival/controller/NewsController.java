package com.festivalmusic.festival.controller;

import com.festivalmusic.festival.service.StageService;
import com.festivalmusic.festival.service.TicketInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NewsController {

    @Autowired
    TicketInfoService ticketInfoService;

    @Autowired
    StageService stageService;

    @GetMapping("festival-news")
    public String getSingersRegistration(Model model) {

        String ticketType = ticketInfoService.getTheMostLikelyTicketToBeSoldOut();
        model.addAttribute("ticket", ticketType);

        Long stage = stageService.getTheMostLikelyStageToBeSoldOut();
        model.addAttribute("stage",stage);

        String genre =  stageService.getTheMostPopularGenre();
        model.addAttribute("genre",genre);

        return "festival-news";
    }

}
