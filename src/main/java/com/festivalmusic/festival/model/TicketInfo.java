package com.festivalmusic.festival.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "TICKETS_INFO")
public class TicketInfo {

    @Id
    @GeneratedValue
    @Column(name = "ticket_info_id")
    private Long ticketInfoId;

    @Column(name = "amount")
    @NotNull
    private int amount;

    @Column(name = "type")
    @NotNull
    private String type;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Stage.class)
    @JoinColumn(name = "stage_id")
    private Stage stageId;


    @OneToMany(mappedBy = "ticketInfoId")
    private List<Ticket> ticket;

    public Long getTicketInfoId() {
        return ticketInfoId;
    }

    public void setTicketInfoId(Long ticketInfoId) {
        this.ticketInfoId = ticketInfoId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Stage getStageId() {
        return stageId;
    }

    public void setStageId(Stage stageId) {
        this.stageId = stageId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "TicketInfo{" +
                "ticketInfoId=" + ticketInfoId +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", stageId=" + stageId +
                ", price=" + price +
                ", ticket=" + ticket +
                '}';
    }
}
