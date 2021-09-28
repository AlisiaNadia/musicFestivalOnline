package com.festivalmusic.festival.controller;

import com.festivalmusic.festival.model.*;
import com.festivalmusic.festival.service.StageService;
import com.festivalmusic.festival.service.TicketInfoService;
import com.festivalmusic.festival.validation.StageValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StageController {

    @Autowired
    StageService stageService;

    @Autowired
    TicketInfoService ticketInfoService;

    @GetMapping("add-stage")
    public String getAddStage(@ModelAttribute("addStage") AddStage addStage, Model model) {

        List<TicketInfo> ticketInfo = new ArrayList<>();

        ticketInfo.add(new TicketInfo());
        ticketInfo.add(new TicketInfo());

        addStage.setTicketInfo(ticketInfo);
        model.addAttribute("addStage", addStage);

    return "add-stage";
    }

    @PostMapping(value = "add-stage", params = "addNewTicket")
    public String addNewTicketType(@ModelAttribute("addStage") AddStage addStage,
                                         BindingResult result, Model model) {

        List<TicketInfo> ticketInfoList = new ArrayList<>();

        if (addStage.getTicketInfo() == null) {
            ticketInfoList.add(new TicketInfo());
        } else {

            ticketInfoList = addStage.getTicketInfo();
            ticketInfoList.add(new TicketInfo());

        }

        addStage.setTicketInfo(ticketInfoList);

        model.addAttribute("addStage", addStage);

        return "redirect:add-stage";
    }

    @PostMapping(value = "add-stage", params = "register")
    public String addStage(@ModelAttribute("addStage") AddStage addStage,
                           BindingResult result, Model model) {

        new StageValidation().validate(addStage, result);

        if (result.hasErrors()) {
            return "add-stage";
        }

        Stage stage = stageService.save(addStage.getStage());

        List<TicketInfo> ticketInfoList = ticketInfoService.saveAll(stage, addStage.getTicketInfo());

        return "redirect:add-stage";
    }

}
