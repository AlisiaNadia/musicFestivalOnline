package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Ticket;

public interface TicketRepository {
    Ticket getTicketId(Long ticketInfoId);

    Long updateTicketNumber(Long ticketInfoId);
}
