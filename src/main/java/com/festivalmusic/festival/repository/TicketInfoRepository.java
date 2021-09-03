package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.TicketInfo;

import java.util.List;

public interface TicketInfoRepository {
    List<TicketInfo> getAll();
}
