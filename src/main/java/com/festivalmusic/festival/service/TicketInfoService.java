package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Stage;
import com.festivalmusic.festival.model.TicketInfo;

import java.util.List;

public interface TicketInfoService {

    List<TicketInfo> getAll();

    String getTheMostLikelyTicketToBeSoldOut();

    List<TicketInfo> saveAll(Stage stage, List<TicketInfo> ticketInfo);
}
