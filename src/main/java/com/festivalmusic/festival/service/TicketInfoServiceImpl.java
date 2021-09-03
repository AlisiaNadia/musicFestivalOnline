package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.TicketInfo;
import com.festivalmusic.festival.repository.TicketInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketInfoServiceImpl implements TicketInfoService {

    @Autowired
    TicketInfoRepository ticketInfoRepository;

    @Override
    public List<TicketInfo> getAll() {
        return ticketInfoRepository.getAll();
    }
}
