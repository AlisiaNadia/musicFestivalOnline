package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.TicketInfo;
import com.festivalmusic.festival.repository.TicketInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TicketInfoServiceImpl implements TicketInfoService {

    @Autowired
    TicketInfoRepository ticketInfoRepository;

    @Override
    public List<TicketInfo> getAll() {
        return ticketInfoRepository.getAll();
    }

    @Override
    public String getTheMostLikelyTicketToBeSoldOut() {
        Map<String, Integer> tickets = ticketInfoRepository.getTheMostLikelyTicketToBeSoldOut();

        String ticketMostLikelyToBeSoldOut = tickets
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .get()
                .getKey();

       return ticketMostLikelyToBeSoldOut;
    }
}
