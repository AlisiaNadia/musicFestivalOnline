package com.festivalmusic.festival.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AUDIENCE_USERS")
public class AudienceUser implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "audience_user_id")
    private Long audienceUserId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "user_info_id")
    private User userId;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Ticket.class)
    @JoinColumn(name = "ticket_id")
    private Ticket ticketId;

    public AudienceUser(User user, Ticket ticketId) {
        this.userId = user;
        this.ticketId = ticketId;
    }

    public AudienceUser() {

    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }


    public Ticket getTicketId() {
        return ticketId;
    }

    public void setTicketId(Ticket ticketId) {
        this.ticketId = ticketId;
    }

}
