package com.festivalmusic.festival.service;

import com.festivalmusic.festival.model.AudienceUser;
import com.festivalmusic.festival.model.User;

public interface AudienceUserService {

    AudienceUser save(Long ticketInfoId, User user);
}
