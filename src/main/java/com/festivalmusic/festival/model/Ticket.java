package com.festivalmusic.festival.model;

import javax.persistence.*;

@Entity
@Table(name = "TICKETS")
public class Ticket {

    @Id
    @GeneratedValue
    @Column(name = "ticket_id")
    private Long ticketId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = TicketInfo.class)
    @JoinColumn(name = "ticket_info_id")
    private TicketInfo ticketInfoId;

    @OneToOne(mappedBy = "ticketId")
    private AudienceUser audienceUser;


    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public TicketInfo getTicketInfoId() {
        return ticketInfoId;
    }

    public void setTicketInfoId(TicketInfo ticketInfoId) {
        this.ticketInfoId = ticketInfoId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", ticketInfoId=" + ticketInfoId +
                ", audienceUser=" + audienceUser +
                '}';
    }
}
