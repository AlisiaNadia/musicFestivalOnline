package com.festivalmusic.festival.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "STAGES")
public class Stage {

    @Id
    @GeneratedValue
    @Column(name = "stage_id")
    private Long stageId;

    @Column(name = "genre")
    private String genre;

    @Column(name = "capacity")
    private int capacity;

    @OneToMany(mappedBy = "stageId")
    private List<Schedule> schedule;

    @OneToMany(mappedBy = "stageId")
    private List<TicketInfo> ticketInfo;

    public Stage() {

    }

    public Stage(Long stageId, String genre, int capacity) {
        this.stageId = stageId;
        this.genre = genre;
        this.capacity = capacity;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    public List<TicketInfo> getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(List<TicketInfo> ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "stageId=" + stageId +
                ", genre='" + genre + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
