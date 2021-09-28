package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Ticket;
import com.festivalmusic.festival.model.User;
import com.festivalmusic.festival.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllForUser(User userId) {

        return ticketRepository.getAllTicketsForUser(userId);
    }
}
