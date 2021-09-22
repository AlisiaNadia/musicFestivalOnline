package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.AudienceUser;
import com.festivalmusic.festival.model.Ticket;
import com.festivalmusic.festival.model.User;
import com.festivalmusic.festival.repository.AudienceUserRepository;
import com.festivalmusic.festival.repository.TicketInfoRepository;
import com.festivalmusic.festival.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AudienceUserServiceImpl implements AudienceUserService {

    @Autowired
    AudienceUserRepository audienceUserRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserService userService;

    @Autowired
    TicketInfoRepository ticketInfoRepository;

    @Override
    public AudienceUser save(Long ticketInfoId, User user) {

        Ticket ticket = ticketRepository.getTicketId(ticketInfoId);

        AudienceUser audienceUser =  audienceUserRepository.save(new AudienceUser(user, ticket));

        ticketRepository.updateTicketNumber(ticketInfoId);

        return audienceUser;
    }
}
