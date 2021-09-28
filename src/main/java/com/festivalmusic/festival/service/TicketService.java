package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.Ticket;
import com.festivalmusic.festival.model.User;

import java.util.List;

public interface TicketService {
    List<Ticket> getAllForUser(User userId);
}
