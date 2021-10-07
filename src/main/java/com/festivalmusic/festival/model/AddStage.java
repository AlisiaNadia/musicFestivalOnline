package com.festivalmusic.festival.model;

import java.util.List;

public class AddStage {

    private Stage stage;

    private List<TicketInfo> ticketInfo;

    private Festival festival;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public List<TicketInfo> getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(List<TicketInfo> ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    @Override
    public String toString() {
        return "AddStage{" +
                "stage=" + stage +
                ", ticketInfo=" + ticketInfo +
                '}';
    }
}
