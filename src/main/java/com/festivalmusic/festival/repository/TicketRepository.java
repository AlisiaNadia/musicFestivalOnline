package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Ticket;
import com.festivalmusic.festival.model.User;

import java.util.List;

public interface TicketRepository {

    Ticket getTicketId(Long ticketInfoId);

    Long updateTicketNumber(Long ticketInfoId);

    List<Ticket> getAllTicketsForUser(User userId);

    Ticket save(Ticket ticket1);
}
