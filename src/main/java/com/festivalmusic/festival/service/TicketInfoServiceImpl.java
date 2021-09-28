package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Stage;
import com.festivalmusic.festival.model.Ticket;
import com.festivalmusic.festival.model.TicketInfo;
import com.festivalmusic.festival.repository.TicketInfoRepository;
import com.festivalmusic.festival.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TicketInfoServiceImpl implements TicketInfoService {

    @Autowired
    TicketInfoRepository ticketInfoRepository;

    @Autowired
    TicketRepository ticketRepository;

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

    @Override
    public List<TicketInfo> saveAll(Stage stage, List<TicketInfo> ticketInfo) {

        for (TicketInfo ticket: ticketInfo) {
            ticket.setStageId(stage);
            ticket.setAmountLeft(ticket.getAmount());

            TicketInfo ticketId = ticketInfoRepository.save(ticket);

            for(int i = 0; i< ticket.getAmount(); i++) {

                Ticket ticketSaved  = ticketRepository.save(new Ticket(ticketId));
            }

        }
        return ticketInfo;
    }
}
