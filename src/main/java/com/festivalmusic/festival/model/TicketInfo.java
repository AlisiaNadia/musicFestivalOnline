package com.festivalmusic.festival.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "TICKETS_INFO")
public class TicketInfo {

    @Id
    @GeneratedValue
    @Column(name = "ticket_info_id")
    private Long ticketInfoId;

    @Column(name = "tickets_amount")
    private Integer amount;

    @Column(name = "tickets_amount_left")
    private Integer amountLeft;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Stage.class)
    @JoinColumn(name = "stage_id")
    private Stage stageId;

    @OneToMany(mappedBy = "ticketInfoId")
    private List<Ticket> ticket;

    public TicketInfo(Integer amount, Integer amountLeft, String type, BigDecimal price, Stage stageId) {
        this.amount = amount;
        this.amountLeft = amountLeft;
        this.type = type;
        this.price = price;
        this.stageId = stageId;
    }

    public TicketInfo() {

    }

    public Long getTicketInfoId() {
        return ticketInfoId;
    }

    public void setTicketInfoId(Long ticketInfoId) {
        this.ticketInfoId = ticketInfoId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(Integer amountLeft) {
        this.amountLeft = amountLeft;
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
                ", amountLeft=" + amountLeft +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
