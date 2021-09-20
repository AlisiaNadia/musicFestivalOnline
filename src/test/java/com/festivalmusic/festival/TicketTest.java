package com.festivalmusic.festival;

import com.festivalmusic.festival.model.Stage;
import com.festivalmusic.festival.model.Ticket;
import com.festivalmusic.festival.model.TicketInfo;
import com.festivalmusic.festival.model.User;
import com.festivalmusic.festival.service.TicketInfoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TicketTest {

    @MockBean
    private TicketInfoService ticketInfoService;

    private List<TicketInfo> ticketInfoList;

    private List<Stage> stageList;

    @BeforeEach
    void setTicketInfoList() {

        this.stageList = new ArrayList<>();
        this.stageList.add(new Stage(1L,"rock", 50));
        this.stageList.add(new Stage(2L,"pop", 70));
        this.stageList.add(new Stage(3L,"country", 50));


        this.ticketInfoList = new ArrayList<>();
        this.ticketInfoList.add(new TicketInfo(20 ,20, "type1", new BigDecimal(12), stageList.get(0)));
        this.ticketInfoList.add(new TicketInfo(20 ,20, "type2", new BigDecimal(10), stageList.get(0)));
        this.ticketInfoList.add(new TicketInfo(10 ,10, "type3", new BigDecimal(15), stageList.get(0)));
        this.ticketInfoList.add(new TicketInfo(40 ,40, "type1", new BigDecimal(12), stageList.get(1)));
        this.ticketInfoList.add(new TicketInfo(20 ,20, "type2", new BigDecimal(10), stageList.get(1)));
        this.ticketInfoList.add(new TicketInfo(10 ,10, "type3", new BigDecimal(15), stageList.get(1)));
        this.ticketInfoList.add(new TicketInfo(20 ,20, "type1", new BigDecimal(12), stageList.get(2)));
        this.ticketInfoList.add(new TicketInfo(20 ,20, "type2", new BigDecimal(10), stageList.get(2)));
        this.ticketInfoList.add(new TicketInfo(10 ,10, "type3", new BigDecimal(15), stageList.get(2)));
    }

    @Test
    public void getAllTicketsInfo() {

        Mockito.when(ticketInfoService.getAll()).thenReturn(ticketInfoList);

        List<TicketInfo> tickets = ticketInfoService.getAll();

        Assert.assertEquals(tickets, ticketInfoList);
    }



}
